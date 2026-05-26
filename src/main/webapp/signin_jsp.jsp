 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in</title>
<link rel="stylesheet" href="./signin.css">
</head>


<body>

<main>
<div class="left">
	<img src="./background.jpg" alt="">	
</div>
<div class="right">
<h1>Signup Page</h1>

<form action="signin" method="post">

<label> Enter id: </label>
<input type="text" name="id">	

<label> Enter First Name: </label>
<input type="text" name="fname">	

<label> Enter Last Name: </label>
<input type="text" name="lname">

<label> Enter Email: </label>
<input type="text" name="email">	

<label> Enter Password: </label>
<input type="text" name="password">	

<label> Enter Phone: </label>
<input type="text" name="phone">	


<div class="box" id="submit">
<button type="submit">submit</button>
<button type="reset">cancel</button>
</div>
</form>
</div>

</main>
		


</body>
</html>