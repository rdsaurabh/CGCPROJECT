<%@page import="com.managers.CategoryManager"%>
<%@page import="org.springframework.ui.ModelMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import ="com.models.Category" %>
<jsp:include page="index.jsp"></jsp:include>
    <%  
    	CategoryManager categoryManager = new CategoryManager();
    	List<Category> catList = categoryManager.getCategories();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel= "stylesheet" href="css/style.css"/>
<style>
#cat-div{
margin-top : 3%; 
}
a{
color :#26004d;
}



img{
float : left;
width : 12%;
height : 12%;
}

a:hover{
text-decoration : #800080;
}
p{
float : left;
margin-left:30%;
color : #800080;
}

</style>
</head>
<body>
<% for(Category c : catList){
%>
<div class="container" id="cat-div">
<h2 class="headings"><a href="show-products/<%=c.getId()%>"><%=c.getName()%></a></h2>
<img class="img-rounded" src="<%="uploaded/"+c.getImgUrl()%>" alt="<%=c.getId()%>"   />
<p><%=c.getDescription()%></p> 
<div style="clear:both;"></div> 
</div>
<%}%>
</body>
</html>