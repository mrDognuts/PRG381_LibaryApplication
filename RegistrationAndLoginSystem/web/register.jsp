<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="servlets.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
            background: url('https://c4.wallpaperflare.com/wallpaper/148/392/948/1920x1080-px-books-interior-design-interiors-knowledge-library-shelves-anime-pokemon-hd-art-wallpaper-preview.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #fff;
            position: relative;
            min-height: 100vh; /* Ensure the body covers the entire viewport height */
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: -1;
        }

        .container {
            background: rgba(0, 0, 0, 0.7); /* Dark background for better contrast */
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            z-index: 1;
            position: relative;
            width: 100%;
            max-width: 500px;
            margin: auto;
        }

        h2 {
            margin-bottom: 30px;
            color: #fff; /* Ensure heading is visible against the dark background */
        }

        table {
            width: 100%;
            margin: 0 auto;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: calc(100% - 22px); /* Adjust for padding */
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            color: #333;
            font-size: 16px;
            box-sizing: border-box;
        }

        input[type="submit"],
        input[type="button"] {
            padding: 12px 25px;
            margin: 10px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #0056b3;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
        }

        input[type="submit"]:active,
        input[type="button"]:active {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="overlay"></div>
    <div class="container">
        <h2>Registration Page</h2>
        <form name="home_page" action="RegisterServlet" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" required /></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required /></td>
                    </tr>
                    <tr>
                        <td>Surname:</td>
                        <td><input type="text" name="surname" required /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required /></td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><input type="text" name="phone" required /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" required /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Register" name="btnRegister" />
            <input type="button" value="Back" name="btnBack" onclick="history.back();" />
        </form>
    </div>
</body>
</html>
