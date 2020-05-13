<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel= "stylesheet" href="css/style.css"/>
 <style>
 body{
 background:url("images	/bg_2.jpg");
 }
 div{
	margin : auto;
	width:100%;
	height:100%;
	margin-top : 15%;
 }
 input{
 margin:1%;
 width :24%;
 padding:1%;
 border : 2px solid  #800080;
 border-radius : 4%;
}
a{
margin-k
text-align : centre;
color :  #ccffff;
}
 </style>
<body>

<div class="form-group container">
<form class="fomr-inline"action="login" method="POST">
<input  type="hidden" name="redirect" value="cart"/><br>
<input type="text" placeholder="enter your email" name="email"/><br>
<input type="password" placeholder="enter your password" name="password"/><br>
<input class="mylinks" type = "submit" value="Log in"/>
</form>
<a class="myfrm"href="signup">New User ? SignUp</a>
</div>

</body>
</html>