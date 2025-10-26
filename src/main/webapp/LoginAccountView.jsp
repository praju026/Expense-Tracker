<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/ViewLogin.css">
<link rel="icon" type="image/png" href="images/logobg.png">

</head>
<body>

<div class="form-container login-container">
    <h2>Login</h2>
    <form action="LoginAccount" method="post" class="login-form">
        <label>Username:</label>
        <input type="text" name="username" placeholder="Enter your username" required><br>

        <label>Email:</label>
        <input type="email" name="email" placeholder="Enter your email" required><br>

        <label>Password:</label>
        <input type="password" name="pwd" placeholder="Enter your password" required><br>

        <input type="submit" value="Login" class="btn">

        <!-- Links below login button -->
        <div class="login-links">
            <a href="RegisterAccountView.jsp">Sign Up</a>
            <a href="ForgotPassword.jsp">Forgot Password</a>
        </div>
    </form>
</div>

</body>
</html>
