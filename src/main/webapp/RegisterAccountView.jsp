<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>

<!-- Common and page-specific CSS -->
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/ViewRegister.css">
<link rel="icon" type="image/png" href="images/logobg.png">

</head>
<body>

<div class="form-container">
    <h2>Create Account</h2>
    <form action="RegisterAccountServlet" method="post" class="create-account-form">
        <label>Username:</label>
        <input type="text" name="username" placeholder="Enter username" required><br>

        <label>Email:</label>
        <input type="email" name="email" placeholder="Enter email" required><br>

        <label>Password:</label>
        <input type="password" name="pwd" placeholder="Enter password" required><br>

        <input type="submit" value="Register" class="btn">

        <div class="login-links">
            <a href="LoginAccountView.jsp" class="btn">Login</a>
            <a href="ForgotPassword.jsp" class="btn">Forgot Password</a>
        </div>
        
    </form>

    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <% } %>
</div>


</body>
</html>
