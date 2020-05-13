<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="weather">
<input type="text" id="one" name ="weather"value="" />
<input type="submit" />
</form>
<script>
	var obj = new XMLHttpRequest();
		obj.open("GET","https://api.darksky.net/forecast/2c019a4120f300fbeddde46cb2ff61dd/37.8267,-122.4233",true);
	obj.send();	
	obj.onreadystatechange = function () {
		if(this.readyState == 4 && this.status == 200){
	var h = 	document.getElementById("one");
	h.value = this.responseText;
		}
	}
</script>
</body>
</html>