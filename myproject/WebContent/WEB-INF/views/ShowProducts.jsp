<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.models.Product" %>
    <% List<Product> productList=(List<Product>)request.getAttribute("productList"); %>
    <jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel= "stylesheet" href="../css/style.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 
<style>
 img{
width :5%;
height :5%;
}
 </style>
 
</head>
<body>
<%for(Product p : productList){ %>
<div class="container">

<h1 class="headings"><%=p.getName() %></h1>
<img src="../uploaded/<%=p.getImgUrl1() %>" alt="<%=p.getImgUrl1()%>"/>
<h3 >Rs.<%=p.getMrp()%></h3>
<a class="mylinks_small" href="../product-details/<%=p.getId()%>"> <i>View Details</i> </a></div>
<%}%>
</body>
</html>