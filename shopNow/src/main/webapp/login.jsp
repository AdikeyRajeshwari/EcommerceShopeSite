<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
	.container {
	background-color:lightpink;
	border:1px solid black;
	margin-top:12px;
	}
  </style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">well come to color's</a>
    </div>
    
    <ul class="nav navbar-nav "  >
    
      <li><a href="login.jsp" class="float-left">sinUp</a></li>
    </ul>
  </div>
</nav>
<div class="container">

	<div class="row">
		<div class="col-sm-12  col-mid-12 ">
		<label class="h3">Login</label>
		
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4  col-mid-4 col-mid-offset-4 ">
			<div class="form-group">
			<form action="log" method="post">
			<label class="control-label">phnNo: </label><input type="text" class="form-control" placeholder="enter userPhnno" name="phnno">
			<label class="control-label">email:  </label><input type="text" class="form-control" placeholder="enter your mail" name="email"></br>
			
			<button class="btn btn-primary">submit</button>
			</form>
			</div>
		</div>
	</div>
</div>
 <!--
<form action="log" method="post">
phnNo:<input type="text" name="phnno"><br>
email:<input type="text" name="email"><br>
<input type="submit" value="submit">
</form>
-->
</body>
</html>