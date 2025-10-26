<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/AddExpenseCss.css">
<link rel="icon" type="image/png" href="images/logobg.png">

</head>
<body>
<%
    if (session.getAttribute("UserName") == null) {
        response.sendRedirect("LoginAccountView.jsp");
        return;
    }
%>

<jsp:include page="SideBar.jsp" />
<jsp:include page="Header.jsp" />


<div class="form-container">
    <h2>Add Expense</h2>
    <form action="AddExpense" method="post">
        <label for="category">Category:</label>
        <input type="text" name="category" id="category" required>

        <label for="amount">Amount:</label>
        <input type="number" name="amount" id="amount" required>

        <label for="date">Date:</label>
        <input type="date" name="date" id="date" required>

        <label for="description">Description:</label>
        <input type="text" name="description" id="description">

        <input type="submit" value="Add Expense">
    </form>
</div>

</body>
</html>
