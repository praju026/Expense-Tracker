<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.praju.model.Expense"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/AddExpenseCss.css">
<link rel="icon" type="image/png" href="images/logobg.png">

<title>Update Expense</title>
</head>
<body>
<%
    Expense e = (Expense) request.getAttribute("expense");
%>

<jsp:include page="SideBar.jsp" />
<jsp:include page="Header.jsp" />

<div class="form-container">
<form action="UpdateExpenseServlet" method="get">
    <input type="hidden" name="id" value="<%= e.getId() %>">
    
    Category: <input type="text" name="category" value="<%= e.getCategory() %>" required><br>
    Amount: <input type="number" step="0.01" name="amount" value="<%= e.getAmount() %>" required><br>
    Date: <input type="date" name="date" value="<%= e.getDate() %>" required><br>
    Description : <input type="text" name="description" value="<%=e.getDescription()%>"><br>
    <input type="submit" value="Update Expense" class="btn">
</form>
</div>
</body>
</html>