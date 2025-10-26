<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="java.util.*,com.praju.model.Expense"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expenses</title>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" type="text/css" href="css/ViewExpense.css">
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


<h2>Expense List</h2>

<div class="table-container">
    <table>
    <tr>
        <th>ID</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Date</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>

    <%
        List<Expense> expenseList = (List<Expense>) request.getAttribute("expenses");
        if (expenseList != null && !expenseList.isEmpty()) {
            for (Expense e : expenseList) {
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getCategory() %></td>
        <td><%= String.format("%.2f", e.getAmount()) %></td>
        <td><%= e.getDate() %></td>
        <td><%= e.getDescription()%> </td>
        <td>
            <a href="EditExpenseServlet?id=<%= e.getId() %>" class="btn">Edit</a>
            <a href="DeleteExpenseServlet?id=<%= e.getId() %>" class="btn" onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="5" class="no-data">No expenses available</td>
    </tr>
    <%
        }
    %>
</table>


    <a href="index.jsp" class="back-btn">Back to Home</a>
</div>

</body>
</html>
