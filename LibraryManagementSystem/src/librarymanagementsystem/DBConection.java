package librarymanagementsystem;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author walter
 */
public class DBConection {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:LibaryManagmentSystem;create=true";
    private Connection con;
    
    //constructor
    public DBConection(){}
    
    public void connect() throws ClassNotFoundException {
        try {
            // Load the JDBC driver
            Class.forName(DRIVER);
            
            // Establish a connection to the database
            this.con = DriverManager.getConnection(JDBC_URL);
            if(this.con != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTables() {
        String createBooksTable = "CREATE TABLE Books (" +
                                  "BookID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                                  "Title VARCHAR(255), " +
                                  "Author VARCHAR(255), " +
                                  "Genre VARCHAR(50), " +
                                  "Publisher VARCHAR(255))";

        String createBorrowersTable = "CREATE TABLE Borrowers (" +
                                      "BorrowerID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                                      "Name VARCHAR(255), " +
                                      "Surname VARCHAR(255), " +
                                      "Email VARCHAR(255), " +
                                      "Phone VARCHAR(20), " +
                                      "Address VARCHAR(255))";

        String createBorrowingHistoryTable = "CREATE TABLE BorrowingHistory (" +
                                    "BorrowingID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
                                    "BorrowerID INT,"+
                                    "BookID INT,"+
                                    "BorrowDate DATE,"+
                                    "FOREIGN KEY (BorrowerID) REFERENCES Borrowers(BorrowerID),"+
                                    "FOREIGN KEY (BookID) REFERENCES Books(BookID))";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createBooksTable);
            stmt.executeUpdate(createBorrowersTable);
            stmt.executeUpdate(createBorrowingHistoryTable);
            System.out.println("Tables created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void insertSampleData() {
    String insertBooks = "INSERT INTO Books (Title, Author, Genre, Publisher) VALUES " +
                         "('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 'Scribner'), " +
                         "('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'J.B. Lippincott & Co.'), " +
                         "('1984', 'George Orwell', 'Non-Fiction', 'Secker & Warburg')";

    String insertBorrowers = "INSERT INTO Borrowers (Name, Surname, Email, Phone, Address) VALUES " +
                             "('John', 'Doe', 'john.doe@example.com', '123-456-7890', '123 Elm St'), " +
                             "('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', '456 Oak St')";

    // Note: Assuming IDs are 1 and 2 for simplicity; adjust if necessary
    String insertBorrowingHistory = "INSERT INTO BorrowingHistory (BorrowerID, BookID, BorrowDate) VALUES " +
                                    "(1, 1, '2023-01-15'), " + // John Doe borrowed 'The Great Gatsby'
                                    "(1, 2, '2023-02-20'), " + // John Doe borrowed 'To Kill a Mockingbird'
                                    "(2, 3, '2023-03-10')";    // Jane Smith borrowed '1984'

    try (Statement stmt = con.createStatement()) {
        // Insert books
        stmt.executeUpdate(insertBooks);
        // Insert borrowers
        stmt.executeUpdate(insertBorrowers);
        // Insert borrowing history
        stmt.executeUpdate(insertBorrowingHistory);
        System.out.println("Sample data inserted successfully");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to add a new borrower record to the database
    public void addBorrower(String name, String surname, String email, String phone, String address) {
        String query = "INSERT INTO Borrowers (Name, Surname, Email, Phone, Address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
            System.out.println("Borrower added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


// Method to update borrower details
    public void updateBorrower(int borrowerId, String name, String surname, String email, String phone, String address) {
        String query = "UPDATE Borrowers SET Name = ?, Surname = ?, Email = ?, Phone = ?, Address = ? WHERE BorrowerID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, address);
            pstmt.setInt(6, borrowerId);
            pstmt.executeUpdate();
            System.out.println("Borrower updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to delete a borrower by ID
    public void deleteBorrower(int id) {
        String query = "DELETE FROM Borrowers WHERE BorrowerID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Borrower deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Method to add a new book record to the database
    public void addBook(String title, String author, String genre, String publisher) {
        String query = "INSERT INTO Books (Title, Author, Genre, Publisher) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setString(4, publisher);
            pstmt.executeUpdate();
            System.out.println("Book added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to update book details
    public void updateBook(int bookId, String title, String author, String genre, String publisher) {
        String query = "UPDATE Books SET Title = ?, Author = ?, Genre = ?, Publisher = ? WHERE BookID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setString(4, publisher);
            pstmt.setInt(5, bookId);
            pstmt.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to delete a book by ID
        public void deleteBook(int bookId) {
            String query = "DELETE FROM Books WHERE BookID = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, bookId);
                pstmt.executeUpdate();
                System.out.println("Book deleted successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    // Method to record a book borrowing transaction
    public void recordBorrowing(int borrowerId, int bookId, Date borrowDate) {
        String query = "INSERT INTO BorrowingHistory (BorrowerID, BookID, BorrowDate) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, borrowerId);
            pstmt.setInt(2, bookId);
            pstmt.setDate(3, borrowDate);
            pstmt.executeUpdate();
            System.out.println("Borrowing recorded successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBorrowing(int borrowingID) {
        String query = "DELETE FROM BorrowingHistory WHERE BorrowingID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, borrowingID);
            pstmt.executeUpdate();
            System.out.println("Borrowing entry deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Method to view borrowing history
    public ArrayList<String[]> viewBorrowingHistory() {
    String query = "SELECT bh.BorrowingID, bh.BookID, b.Title, b.Genre, br.Name || ' ' || br.Surname AS FullName, bh.BorrowDate " +
                   "FROM BorrowingHistory bh " +
                   "JOIN Books b ON bh.BookID = b.BookID " +
                   "JOIN Borrowers br ON bh.BorrowerID = br.BorrowerID";
    ArrayList<String[]> results = new ArrayList<>();
    try (Statement stmt = con.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String[] record = {
                rs.getString("BorrowingID"),
                rs.getString("BookID"),
                rs.getString("Title"),
                rs.getString("Genre"),
                rs.getString("FullName"),
                rs.getString("BorrowDate")
            };
            results.add(record);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return results;
}


    
    // Method to view all borrowers
    public ArrayList<String[]> viewBorrowers() {
        String query = "SELECT * FROM Borrowers";
        ArrayList<String[]> results = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String[] borrower = {
                    rs.getString("BorrowerID"),
                    rs.getString("Name"),
                    rs.getString("Surname"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Address")
                };
                results.add(borrower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
        // Method to view all borrowers
    public ArrayList<String[]> viewBooks() {
        String query = "SELECT * FROM Books";
        ArrayList<String[]> results = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String[] book = {
                    rs.getString("BookID"),
                    rs.getString("Title"),
                    rs.getString("Author"),
                    rs.getString("Genre"),
                    rs.getString("Publisher"),
                };
                results.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    
    // Method to search for a book by ID
public String[] searchBookById(int bookId) {
    String query = "SELECT * FROM Books WHERE BookID = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, bookId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new String[] {
                rs.getString("BookID"),
                rs.getString("Title"),
                rs.getString("Author"),
                rs.getString("Genre"),
                rs.getString("Publisher")
            };
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

// Method to search for a borrower by ID
public String[] searchBorrowerById(int borrowerId) {
    String query = "SELECT * FROM Borrowers WHERE BorrowerID = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, borrowerId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new String[] {
                rs.getString("BorrowerID"),
                rs.getString("Name"),
                rs.getString("Surname"),
                rs.getString("Email"),
                rs.getString("Phone"),
                rs.getString("Address")
            };
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public ArrayList<String[]> viewBorrowingHistory(int borrowerId) {
    String query = "SELECT bh.BorrowingID, bh.BookID, b.Title, b.Genre, bh.BorrowDate " +
                   "FROM BorrowingHistory bh " +
                   "JOIN Books b ON bh.BookID = b.BookID " +
                   "WHERE bh.BorrowerID = ?";
    ArrayList<String[]> results = new ArrayList<>();
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, borrowerId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String[] record = {
                rs.getString("BorrowingID"),
                rs.getString("BookID"),
                rs.getString("Title"),
                rs.getString("Genre"),
                rs.getString("BorrowDate")
            };
            results.add(record);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return results;
}


}
