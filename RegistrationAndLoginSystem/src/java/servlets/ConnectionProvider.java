//Justin Steyn 57830
//Jacques Van Niekerk 577343
//Nadrian Potonas 577662 
package servlets;

import java.sql.*;



public class ConnectionProvider {

    // Database connection details
    private static final String db_URL = "jdbc:postgresql://localhost:5432/Login_reg_LibarySystem";
    private static final String db_username = "postgres";
    private static final String db_password = "admin";
    private static final String db_Driver = "org.postgresql.Driver";

    Connection con;
    public ConnectionProvider() {
        // Constructor
    }

    public Connection getCon() throws ClassNotFoundException, SQLException {
        // Load PostgreSQL JDBC driver
        try {
            try {
                Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("PostgreSQL JDBC Driver not found.", e);
}

            Class.forName(db_Driver);
        
            // Establish the connection
            this.con = DriverManager.getConnection(db_URL, db_username, db_password);
            if (this.con != null) {
                System.out.println("Connected to DB");}
        } catch (SQLException ex) {
            System.out.println("Could not connect"+ ex.getMessage());
        }

        return con;
    }
    public void add(String username,String name,String surname,String password,String phone,String email) throws ClassNotFoundException{
        PreparedStatement pstm;
        try {
            pstm = con.prepareStatement("INSERT INTO Student (username,name,surname,password,phone,email) VALUES (?, ?, ?, ?, ?, ?)");
            pstm.setString(1, username);
            pstm.setString(2, name);
            pstm.setString(3, surname);
            pstm.setString(4, password);
            pstm.setString(5, phone);
            pstm.setString(6, email);  
            
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Could not add data"+ex.getMessage());
        }
    }
}
