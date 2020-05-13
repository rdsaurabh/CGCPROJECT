<%@page import="com.managers.AddressManager"%>
<%@page import="com.models.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.common.Cart"%>
<%@page import="com.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="index.jsp"></jsp:include>
    <% User user = (User)session.getAttribute("logged_user");
    	double total = Cart.getInstance().getTotal();
   		List<Address> addList = (List<Address>)request.getAttribute("addressList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel="stylesheet" href="css/style.css" />
 <style>
 div #ad-frm{
 	background: linear-gradient(#800080,#fff);
	margin : auto;
	width:100%;
	height:100%;
	position : fixed;
	margin-top:0;
	
 }
 input{
 margin:1%;
 width :24%;
 padding:1%;
 border : 2px solid  #800080;
 border-radius : 4%;
}
</style>
</head>
 
<body>

<div class="container-fluid">
<h1 class="mylinks">Place Your order</h1>
<div style="position:absolute; display:none;"class="container-fluid " id="ad-frm" style="display : none;">
<form action ="add-address" method="POST" class="form-horizontal">
<input type="text" placeholder="Flat/Street/Village" name="street"><br>
<input type="text" placeholder="Landmark" name="landmark"><br>
<input type="text" placeholder="Phone" name="phone"> <br>
<input type="text" placeholder="City" name="city"><br>
<input type="text" placeholder="State" name="state"><br>
<input type="text" placeholder="Country" name="country"><br>
<input type="text" placeholder="Pin Code" name="pincode"><br>
<input type="submit" value="Add" class="mylinks_small"/><br>
<a id="cls" href="#" class="mylinks_small">Go Back</a>
 </form>
 </div>




<button id="new-ad"class="mylinks_small" style="float:right;">Add a new address</button><br>
<h3> To :<span ><%=user.getName() %></span></h3><br>
<h3><i>Email : <%=user.getEmail() %></i></h3><br>
<b class="mylinks_small" style="background:#cc0052;">Total:<%=total%></b><br>
<form action ="place-order" method="POST" class="form-group">
<select style="margin-top : 3%;"class="form-control"name="address">
<option>Select shipping address</option>
<%for(Address a : addList){ %>
<option value="<%=a.getId()%>"><%=a.getCompleteAddress()%></option>
<%} %>
</select>
<br>
<input style="margin-top :1%;"type ="submit" value="Pay<%=total%>" class="mylinks_small">
</form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$("#new-ad").click(function(){
		$("#ad-frm").show();
		
});
	$("#cls").click(function(){
		
		$("#ad-frm").hide();
	});
	
});
</script>

</body>
</html>