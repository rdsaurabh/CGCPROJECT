<%@page import="com.common.Common"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.models.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.common.Cart" %>
    <% Cart cart = Cart.getInstance(); %>
<jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" />
<link rel= "stylesheet" href="css/style.css"/>
<style>


</style>
</head>
<body>
<table class="table table-striped">
<tr>
<th>Product</th>
<th>Price </th>
<th>Quantity</th>
<th>Total</th>
</tr>
<%
double grandTotal=0;
for(Product p:cart){
%><tr>
<td><%=p.getName()%></td>
<td><%=p.getMrp()%></td>
<td><%=p.getQuantity()%></td>
<td><%=p.getTotal()%></td>
</tr>
<%}%>
<tr>
<td></td>
<td></td>
<td>Grand Total: </td>
<td><%=cart.getTotal()%></td>
</tr>
</table>
<% if(cart.size()>0){ %>
<a class="mylinks" href="checkout">Proceed To CheckOut</a>
<%}else{ %>
<a class="mylinks" href="show-category">Back To products</a>
<%} %>
</body>
</html>