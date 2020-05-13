<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <jsp:include page="index.jsp"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<style>

.slide_view{
margin: 1%;
position:relative;
width:98%;

height:500px;
}

.slide_view img{
	position:absolute;
	top:0;
	left:0;
	background-repeat:no-repeat;
	width:100%;
	height:100%;
	display:none;
	opacity : 1;
	
}
</style>
</head>
<body>
<div class="slide_view" id="slide_view"> 
<img  class="img-rounded" src="images/slide_one.jpg"  alt="image 1"  />
<img  class="img-rounded"  src="images/slide_two.jpg" alt="image 2" />
<img  class="img-rounded" src="images/slide_three.jpg" alt="image 3" />
<img  class="img-rounded"  src="images/slide_four.jpg" alt="image 3" />
</div>


<script>

	var currentSlide=0;
		function changeSlide(){
		var images = document.getElementById('slide_view').getElementsByTagName('img');
		 
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