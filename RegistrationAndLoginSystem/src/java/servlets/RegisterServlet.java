//Justin Steyn 57830
//Jacques Van Niekerk 577343
//Nadrian Potonas 577662 
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String PHONE_PATTERN = "^\\d{10}$"; // 10 digits
    private static final int MIN_PASSWORD_LENGTH = 8; // Minimum length for password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from request
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Validate inputs
        if (username == null || username.trim().isEmpty() ||
            name == null || name.trim().isEmpty() ||
            surname == null || surname.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('All fields are required. Please fill in all fields.');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }

        // Validate phone number
        if (!Pattern.matches(PHONE_PATTERN, phone)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Phone number must be exactly 10 digits.');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }

        // Validate password
        if (password.length() < MIN_PASSWORD_LENGTH) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password must be at least " + MIN_PASSWORD_LENGTH + " characters long.');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }

        // Database connection
        ConnectionProvider cp = new ConnectionProvider();
        try (Connection con = cp.getCon()) {
            String query = "INSERT INTO public.\"Users\" (\"Username\", \"Name\", \"Surname\", \"Password\", \"Phone\", \"Email\") VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, email);

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("login.jsp");
            } else {
                out.println("Registration failed, please try again.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}
