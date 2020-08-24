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
  width: 300px;
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
      <li class="active"><a href="#" onclick="myFunction()">home</a></li>
      <li><a href="#" onclick="myFunction()">men</a></li>
      <li><a href="#" onclick="myFunction()">Women</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button class="btn btn-default" onclick="myFunction()">submit</button>
      
    </form>
    <ul class="nav navbar-nav"  >
    <li><a href="registration.jsp" class="float-right">CreateAcount</a></li>
      <li><a href="login.jsp" class="float-right">sinIn</a></li>
    </ul>
  </div>
</nav>
<div class="row">
<div class="col-sm-12 col-mid-12">
     
     <img src="C:\Users\d1\Desktop\images\mutlipleWatches.jpg">
</div>
<%
String sql = "SELECT * from test.productinformayion";
String url = "jdbc:mysql://localhost:3306?user=root&password=techouts";
String driver = "com.mysql.jdbc.Driver";

try  {
	
		
	Class.forName(driver);//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306\test","root","techouts");
		Connection connection = DriverManager.getConnection(url);
		//Class.forName("com.mysql.jdbc.Driver");
	Statement statement = connection.createStatement();
	
	ResultSet result = statement.executeQuery(sql);
	
		while (result.next()) {
		
			String productName = result.getString("productName");
			Blob blob = result.getBlob("images");
			String productName1=result.getString("ProductName");
			if(blob != null)
			{
			
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096]; //4096bytes = 4kb
				int bytesRead = -1;
				
				while ((bytesRead = inputStream.read(buffer)) != -1) { //bytesRead=4kb
				outputStream.write(buffer, 0, bytesRead);
				}
				
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
%>
 <!--<div class="container">

<div class="row">
     <div class="col-sm-3 col-mid-4 p-5 bg-success">
     
      <img src="data:image/jpeg;base64,<%=base64Image%>">
      <button class="btn" onclick="myFunction()">clickMe</button>
      
    </div>
  </div> 
  -->
  <div style="display: inline-block; text-align: center; margin: 10px;">
			<button onclick="myFunction()">
				<table>
					<tr>
						<td><img style="margin: 10px;"
							src="data:image/jpeg;base64,<%=base64Image%>" width="240"
							height="300"  /></td>
					</tr>
					<tr>
						<td><%=productName1%></td>
					</tr>
				</table>
			</button>
		</div>
		
<%
}
		}
} catch (Exception ex) {
ex.printStackTrace();
throw ex;
}
%>
<script>
// When the user clicks on div, open the popup
function myFunction() {
	alert("plese SinIn!");
}
</script>
</body>
</html>
