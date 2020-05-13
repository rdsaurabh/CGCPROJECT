<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="LogoutHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel= "stylesheet" href="css/style.css"/>
<style type="text/css">
*{
margin: 15px;
}
.myfrm{
	margin : auto;
	width:100%;
	height:100%;
	margin-top : 15%;
 }
 .myfrm-flds{
 margin:1%;
 width :24%;
 padding:1%;
 border : 2px solid  #800080;
 border-radius : 4%;
}

</style>
</head>
<body>
<div >
<form method="POST" action="add-new-cat" enctype="multipart/form-data">
<input class="myfrm-flds" type="text" placeholder="enter category name" name="name"/><br>
<textarea class="myfrm-flds" placeholder="category description" name="description"></textarea><br>
<input class="mylinks_xsmall" type="file" name="image" /><br>
<input class=" mylinks_xsmall" type="submit"/>
</form>
<a class="mylinks_xsmall"href="adm-index">BACK TO PREVIOUS PAGE</a>
</div>
</body>
</html>