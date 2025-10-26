<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIDEBAR</title>
<style>
/* Sidebar container */
.sidebar {
    width: 220px;
    float: left;
    background-color: #2c3e50;
    height: 100vh;
    color: white;
    padding: 20px;
    box-sizing: border-box;
}

/* Logo wrapper */
.sidebar-logo img {
    max-width: 100%;    /* Fit sidebar width */
    max-height: 100px;  /* Restrict height */
    display: block;
    margin: 0 auto 20px auto; /* Center and space below */
}
</style>
</head>
<body>
<div class="sidebar">
    <div class="sidebar-logo">
        <img alt="logo" src="/ExpenseServlet/images/logobg.png">
    </div>
    <nav style="display:flex; flex-direction:column; gap:15px;">
        <!-- <a href="Dashboard.jsp" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">Dashboard</a> -->
        <a href="AddExpense.jsp" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">Add Expense</a>
        <a href="ViewExpenseServlet" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">View Expenses</a>
        <a href="EditExpenseServlet?id=1" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">Update Expense</a>
        <!-- <a href="SummaryServlet" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">Summary</a> -->
        <a href="Logout" style="color:white; text-decoration:none; padding:10px; display:block; border-radius:5px;">Logout</a>
    </nav>
</div>
</body>
</html>
