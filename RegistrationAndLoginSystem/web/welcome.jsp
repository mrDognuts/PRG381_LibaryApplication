<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
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

        a.button {
            display: inline-block;
            padding: 12px 25px;
            margin: 10px;
            color: #fff;
            background-color: #007BFF;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        a.button:hover {
            background-color: #0056b3;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
        }

        a.button:active {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="overlay"></div>
    <div class="container">
    <h2>Welcome, ${username}!</h2>
    <a href="C:\Users\walte\OneDrive - belgiumcampus.ac.za\STUDIES\3ThirdYear\PRG381 Programing\Exercises\Milestone2/desktop-application.jar" download>Open Library Management System</a>
    <a href="login.jsp" class="button">Logout</a>
    </div>
</body>
</html>
