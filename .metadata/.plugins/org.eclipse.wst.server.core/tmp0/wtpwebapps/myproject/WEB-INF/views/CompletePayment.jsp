<%@page import="com.models.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    
    Order o = (Order)request.getAttribute("order");
    
    %>
    <jsp:include page="index.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel= "stylesheet" href="css/style.css"/>
</head>

<body>
<form method="POST" action="complete-payment" id="frm">
<input class="mylinks" id="status" type="hidden" name="statusId" value="0"/>
<input class="mylinks" type="hidden" name="orderId" value="<%=o.getId()%>"/>
<div style="position:absolute;margin-left:35%;margin-top:20%;">
<button class="mylinks" >CompletePayment</button> 
<button class="mylinks" >Cancel</button>
</div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$("button").click(function(){
	if($(this).html()=="CompletePayment"){
		$("#status").val("1");
		alert("Payment Completed!Your Order has been placed.");
		$("#frm").submit();
		}
	else{
		
		alert("Payment Cancelled!");
	}
	
		
	});
	
	
});

</script> 
 

</body>

</html>