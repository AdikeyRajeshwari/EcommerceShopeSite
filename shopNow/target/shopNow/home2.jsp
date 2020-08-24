<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
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
      <li class="active"><a href="#">home</a></li>
     <!--   <li><a href="men.jsp">men</a></li>
      <li><a href="women.jsp">Women</a></li>-->
      <c:set var="set" value="${sessionScope.set}" scope="session" />

      <c:forEach var="l" items="${set}">
      <li><a href="basedOnGender?type=${l}">${l}</a></li>
      </c:forEach>
      
    </ul>
    <form class="navbar-form navbar-left" action="navForm">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button class="btn btn-default">submit</button>
      
    </form>
    <ul class="nav navbar-nav"  >
     
     <c:set var="email" value="${sessionScope.email}" scope="session" />
     <li><a href="#">${email}</a>
      <li><a href="home.jsp" class="float-right">logOut</a></li>
      <li><a href="viewCartIteams?email=${email}" class="float-right">CartIteams</a></li>
    </ul>
  </div>
</nav>


  
 
 <!--  <c:forEach var="l" items="${arrayList}">  
 </br>
 <table>
 <tr>
   <td><c:out value="${l.id}"/></td>
  <td> <c:out value="${l.name}"/></td>
  <td><c:out value="${l.phnno}"/> </td> 
  <tr> <td><c:out value="${l.password}"/></td> 
   </tr>   
   </table>
</c:forEach> -->
 
<!--   <div class="row">
    <div class="col-sm-4 col-mid-6 p-5 bg-success">
     <c:forEach var="l" items="${list}"> 
      <img src="data:image/jpg;base64,${l.base64Image}" width="100" height="200"/>
  <button class="btn" onclick="document.location='item.jsp'" >clickMe</button>
 <c:set var="userId" value="${l.productId}" scope="session" /> 
  <c:set var="imagevalue" value="${l.base64Image}" scope="session" /> 
  </c:forEach>
    </div>
  </div> 
</div>-->
    
 
 
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
