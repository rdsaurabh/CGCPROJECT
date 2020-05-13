<%@page import="com.common.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.models.User" %>   
   <%  User user = (User)session.getAttribute("logged_user");
   		int size = Cart.getInstance().size();
   %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel= "stylesheet" href="css/style.css"/>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>

a{
text-decoration: none;
color:#fff;
}

nav{
background :linear-gradient(to left, #800080,#fff);
height  : 50px;
}

nav  a{
color  :#fff;
margin-left  :3%;
float: right;
height : 100%;
position : relative;

}

nav a span{
	padding-top:15px;
	display:block;
}

#ham{
float : left;
margin-left: 15px;
}

.slide{
display : none;
position : absolute;
}
.fade {
-webkit-animation: fade 5s;
animation: fade 5s;
-moz-animation: fade 5s;
-o-animation: fade 5s;
}

a:hover{
color : #00ffbf;
text-decoration: none;
}
#dropdown_menu{
position :absolute;
background :linear-gradient( #800080,#fff);
height : 100%;
width : 15%;
top : 0;
left : 0;
display : none;
z-index :1;

}

#dropdown_list{
list-style-type:none;
padding-left : 5%;
margin-top : 15%;
margin-left : 10%;
color : #fff; 
}



#dropdown_list li{
margin : 10%;
}

#login_div{
width :80%;
height :80%; 
position : fixed;
top : 10%;
left : 10%;
display : none;
z-index :1;
}

#login-form{
margin:15%;
margin-left:30%;
}

#login-form input{
margin : 3%;
}

.menubar{
	float:right;
	margin-right:10px;
	
}
.menubar li{
	color:white;
	padding:10px;
	list-style:none;
	display:inline-block;
}
.menubar li a{
	color:white;
}
.menubar li:hover{
	
}
.submenu{
	margin-top:10px;
}
.menubar a,.submenu a{
	cursor:pointer;
}
 .submenu{
 	display:none;
 	float:right;
	position:absolute;
    top: 40px;
    right: 00px;
    z-index : 5;
}
.submenu li{
	background : #800080; 
	display:block;
	color:white;
}
.menubar li{
	line-height:35px;
}

.submenu  li {
padding : 50px;
}

</style>
</head>

<body>
<nav>
<i class="fa fa-bars" id="ham" style="float:left;margin : 20px;"></i>
<ul class="menubar">

	<li>
		<a href="home"><i class="fa fa-home">Home</i></a>
	</li>
	<li>
	<a href="show-category"><i class="fa fa-list-alt" aria-hidden="true">Categories</i></a>
	</li>
	
	<li>
		<a href="cart"><i class="fa fa-shopping-cart">Cart</i></a>
	</li>
	
	
	<li class=" dropdown" > 
	<% if(user == null){ %>
		<a href="#" id="login_btn"><i class="fa fa-user">LogIn</i></a>
	<%}else{
		%>
			<a href="#"><i class="fa fa-user fa fa-angle-down"><%=user!=null?user.getName().toUpperCase():""%></i>
	
			<ul class="submenu">
				<li >
					<a href="logout">Logout</a>
				</li>
				
			</ul>
	</a>		<%
	}%>
	</li>
</ul>	

</nav>

<div id="login_div" style="z-index:6"> 
<div style=" float : left;background:blue; height : 100%;width:30%; border-radius:0px 0px 0px 90px;"></div>
<div class="form-group" style="float : right;background-image : url('images/login_img.png'); background-size:100% ,100%; background-repeat:no-repeat; height : 100%; width:70%;">
<i id="close" class="fa" style="cursor:pointer;float : right; margin-right :1%;">&#xf00d;</i>
<form id = "login-form" class="form-inline" method="POST" action="login">
<input type="email" class="form-control" placeholder="Enter your email" name= "email"/><br/>
<input type="password" class="form-control" placeholder="Enter your password"name="password"/><br/>
<input type="hidden" name="redirect" value=""/>
<input type = "submit" class="form-control" class="mylinks" value="LogIn"/>
</form>
<a href="signup" style="margin-left : 35%">New User?Sign up</a>
<button class="mylinks_xsmall" onclick="signIn();">Signin with Google</button>
</div>
</div>
<div id ="dropdown_menu">
<ul id="dropdown_list">
<li >Home</li>
<li><a href="show-category">categories</a></li>
<li><a href="cart">Cart</a></li> 
<li>About us</li>
</ul>
<hr/>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/6.3.3/firebase-app.js"></script>
  <script src="https://www.gstatic.com/firebasejs/6.3.3/firebase-auth.js"></script>
  <script src="https://www.gstatic.com/firebasejs/6.3.3/firebase-firestore.js"></script>
  

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#config-web-app -->

<script>

$(".dropdown").click(function(){
	$(".submenu").toggle();
});
  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyCvFhIJKpqIUkRoxaZlACwL46kBiOLOR6M",
    authDomain: "webproject-72b83.firebaseapp.com",
    databaseURL: "https://webproject-72b83.firebaseio.com",
    projectId: "webproject-72b83",
    storageBucket: "",
    messagingSenderId: "1035293713734",
    appId: "1:1035293713734:web:aff3812543bf6e53"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);

var provider = new firebase.auth.GoogleAuthProvider();
provider.addScope('https://www.googleapis.com/auth/contacts.readonly');
firebase.auth().languageCode = 'en';
function signIn(){/*
	firebase.auth().signInWithPopup(provider).then(function(result) {
		  // This gives you a Google Access Token. You can use it to access the Google API.
		  var token = result.credential.accessToken;
		  // The signed-in user info.
		  var user = result.user;
		  // ...
		}).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  // The email of the user's account used.
		  var email = error.email;
		  // The firebase.auth.AuthCredential type that was used.
		  var credential = error.credential;
		  // ...
		});
	*/
	firebase.auth().signInWithRedirect(provider);

}
function sendSigninDetails(userData){

	var obj = new XMLHttpRequest();
	var URL="http://localhost:8080/myproject/signin-with-google";
	obj.open("POST",URL,true);
	obj.send(userData);
	obj.onreadystatechange = function () {
		if(this.readyState == 4 && this.status == 200){
			
			if(this.responseText=="success"){
				window.location.href="";
			}
			else{
				alert("Failed to signin");
			}
			
		}
	}
	
	}

firebase.auth().getRedirectResult().then(function(result) {
	  if (result.credential) {
	    // This gives you a Google Access Token. You can use it to access the Google API.
	    var token = result.credential.accessToken;
	    // ...
	  }
	  // The signed-in user info.
	  var user = result.user;
	  if(user!=null){
		  alert("success");
		  alert(JSON.stringify(user)); 
		  sendSigninDetails(JSON.stringify(user));
	  }
 }).catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  // The email of the user's account used.
	  var email = error.email;
	  // The firebase.auth.AuthCredential type that was used.
	  var credential = error.credential;
	  // ...
	  alert("failed"+errorMessage);
	});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#ham").hover(function(){
	$("#dropdown_menu").show(80);
});

$(document).click(function(){
	$("#dropdown_menu").hide(80);
});

$("#login_btn").click(function(){
	$("#login_div").show();
});

$("#close").click(
		function(){
			$("#login_div").hide();

});
});
</script>
</body>
</html>