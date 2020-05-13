<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.models.Product" %>
    <% Product product = (Product)request.getAttribute("product");  %>
    <jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel="stylesheet" href="../css/style.css" />
<style>
#cart-form{
display : none;
width : 100%;
height : 100%;
position  :absolute;
}
img{
width : 300px;
height : 500px;
display:none;
margin-left : 35%;

}

.two-btns{
position : absolute;right:10%;bottom:5%;font-size:21px;

}
.two-btns li{
display : inline-block;
list-style : none;
}
</style>
</head>
<body>
<div id= "pd"class ="container">
<h1 class ="mylinks"><%=product.getName() %></h1>
<div style="position : relative;">
<img src="../uploaded/<%=product.getImgUrl1() %>" alt="<%=product.getImgUrl1()%>"/>
<img src="../uploaded/<%=product.getImgUrl2() %>" alt="<%=product.getImgUrl2()%>"/>
<ul class="two-btns" >
<li class="mylinks_small" style="color : #fff; background  :#ff1a1a; ">Rs.<%=product.getMrp()%></li>
<li><a href="#" id="cart-pop" class="mylinks_small">Add To Cart</a></li>
<li style="display: block;">
<div class ="container" id="cart-form" class="form-group" style="positon:absolute !important;top:110%;">
 <form action="../add-to-cart"  method="POST">
<input type="hidden" name="productId" value="<%=product.getId()%>"/>
<input type="text" placeholder="Quantity" name="quantity" />
<input class="mylinks_small"type="submit" value="Add" />
</form>
</div>
</li>
</ul>

</div>
<h4><i class="fa fa-archive"></i>Seller:<%=product.getManufacturer() %></h4>

<p><%=product.getDescription() %></p>




</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$("#cart-pop").click(function(){
	$("#cart-form").show();
});

var currentSlide=0;
function changeSlide(){
var images = document.getElementById('pd').getElementsByTagName('img');
 
for(var i = 0; i < images.length; i++){
	if(currentSlide==i){
		images[i].style.display="block";
	}
	else{
		images[i].style.display="none";
	}
}
currentSlide++;
if(currentSlide>=images.length){
	currentSlide=0;
}
setTimeout(changeSlide,3000);
}
changeSlide();
</script>
</body>
</html>