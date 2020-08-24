<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
   <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@page isELIgnored="false" %>
<html lang="en">
<head>
  <title>Bootstrap Example1</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  
  </style>
</head>
<body>
<form action="particularIteam" method="post">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">well come to color's</a>
    </div>
    
    <ul class="nav navbar-nav "  >
    
     <li><a href="home.jsp" class="float-right">logOut</a></li>
    </ul>
  </div>
</nav>
  
<div class="container align-self-center" >
	<div class="row">
		<div class="col-sm-10">
		
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test" user="root" password="techouts"/>
	<sql:query dataSource="${db}" var="rs">  
 
select * from productinformayion where productId=?;
<sql:param value="${sessionScope.productid}"/>

</sql:query> 

<c:forEach var="table" items="${rs.rows}">  
 
     
   <img src="data:image/jpg;base64,${sessionScope.image}" width="200" height="400"/><br>
  
   <c:out value="${table.description}"/><br>
   <c:out value="${table.productPrice}"/>/-<br>

    
</c:forEach> 
		</div>
	</div>
 
          



<a href="buy?productId=${productId}">AddCart</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="purches?productId=${productId}">purches</a>
</div>


</form>
</body>
</html>
