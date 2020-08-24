<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>registration</title>
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
</head>
<body>
<p>well come to Registration page</p>
<form action="reg" method="post">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">well come to color's</a>
    </div>
    
    <ul class="nav navbar-nav "  >
    
      <li><a href="login.jsp" class="float-left">sinIn</a></li>
    </ul>
  </div>
</nav>
<div class="container">

	<div class="row">
		<div class="col-sm-12  col-mid-12 ">
		<label class="h3">Registration</label>
		
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4  col-mid-4 col-mid-offset-4 ">
			<div class="form-group">
			<label class="control-label">name : </label><input type="text" class="form-control" placeholder="enter userName" name="name">
			<label class="control-label">phnNo : </label><input type="text" class="form-control" placeholder="enter phnNo" name="phnNo"><br>
			<label class="control-label">email : </label><input type="text" class="form-control" placeholder="enter email" name="email">
			<label class="control-label">passwprd : </label><input type="password" class="form-control" placeholder="enter password" name="password"><br>
			
			<button class="btn btn-primary">submit</button>
			</div>
		</div>
	</div>
</div>
</form>

</body>
</html>