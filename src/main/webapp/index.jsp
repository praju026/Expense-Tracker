<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="icon" type="image/png" href="images/favicon.png">

<link rel="stylesheet" type="text/css" href="css/ViewIndex.css">
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

<div class="home-container">
    <h2>Welcome, ${UserName } </h2>

    <a href="AddExpense.jsp">Add Expenses</a>

    <form action="ViewExpenseServlet" style="display:inline-block;">
        <input type="submit" value="View Expenses" class="btn">
    </form>
</div>

</body>
</html>
