<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HEADER</title>
</head>
<body>
<!-- header.jsp -->
<div style="margin-left:220px; background-color:#ecf0f1; padding:15px; display:flex; justify-content:space-between; align-items:center;">
    <h1 style="margin:0; font-size:24px; color:#2c3e50;">Expense Tracker</h1>
    <div>
        Welcome, <b><%= session.getAttribute("UserName") %></b>
        <a href="Logout" style="margin-left:20px; text-decoration:none; color:#e74c3c;">Logout</a>
    </div>
</div>

</body>
</html>