	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import= "com.models.Category" %>
    <% List<Category> catList = (List<Category>)request.getAttribute("catList"); %>
     <jsp:include page="LogoutHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel= "stylesheet" href="css/style.css"/>
<style>
form input {
margin : 1%;
}
div{
margin : auto;
	width:100%;
	height:100%;
	margin-left  :5%;
	
}
input,select,textarea{
margin:1%;
 width :24%;
 padding:1%;
 border : 2px solid  #800080;
 border-radius : 4%;
}
</style>
</head>
<body>
<div>
<form action="add-new-product" method="POST" enctype="multipart/form-data">
<input type="text" placeholder="product name" name="name"/><br>
<select name="categoryId">
<%for(Category c : catList ){   %>
<option value="<%=c.getId()%>"><%=c.getId()+" "+c.getName()%></option>
<%} %>
</select>
<br>
<textarea  placeholder="product description"  name = "description"> </textarea><br>
<input type ="text" placeholder="MRP" name = "mrp"> <br>
<input type ="text" placeholder="Discount on product" name="discount"><br> 
<input class="mylinks_xsmall" type="file" name="imgOne"/><br>
<input class="mylinks_xsmall" type="file"  name="imgTwo"/>	<br>
<input type="text" placeholder="manufacturer" name="brand"/><br>
<input  class="mylinks_xsmall" type ="submit" value="Add Product"/><br>
</form>

<a class="mylinks_xsmall" href="adm-index">BACK TO PREVIOUS PAGE</a>
</div>
</body>
</html>