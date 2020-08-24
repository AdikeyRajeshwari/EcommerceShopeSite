<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  .container {
  position: relative;
  width: 100%;
 
}

.container img {
  width: 100%;
  height: 300px;
}

.container .btn {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #f1f1f1;
  color: black;
  font-size: 16px;
  padding: 16px 30px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}

.container .btn:hover {
  background-color: black;
  color: white;
}






  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">well come to color's</a>
    </div>
    <br><br><br>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home2.jsp">home</a></li>
      <li><a href="#">for mens</a></li>
      <c:forEach var="l" items="${list}">
      <li><a href="#">{l.tyepe}</a></li>
      </c:forEach>
     
    </ul>
    <form class="navbar-form navbar-left" action="">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button class="btn btn-default">submit</button>
      
    </form>
    <ul class="nav navbar-nav"  >
    <li><a href="registration.jsp" class="float-right">CreateAcount</a></li>
      <li><a href="home.jsp" class="float-right">logOut</a></li>
    </ul>
  </div>
</nav>



<div style="display: inline-block; text-align: center; margin: 10px;">
			
				<table>
					<tr>
					  
						<td>
						<c:forEach var="l" items="${list}">
						 <a href="productDetails?productId=${l.productId}">
						 <img style="margin: 10px;"
							src="data:image/jpeg;base64,${l.base64Image}" width="240"
							height="300"  />
							</a>
						<c:out value="${l.productName}"/>
							</c:forEach>
							</td>
								<tr>
							<td><c:out value="${l.productName}"/></td>
					</tr>	
							
				 
					</tr>
					
				</table>
		
		</div>
		
		




</body>
</html>
