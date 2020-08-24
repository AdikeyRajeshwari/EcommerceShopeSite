<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label>you are cart iteams are</label>
  
<c:forEach var="l" items="${list}">  
 
<!--   <table>
 <tr>
 <td> <img style="margin: 10px;"
							src="data:image/jpeg;base64,${l.base64Image}" width="240"
							height="300"  /></td>
							   <td><c:out value="${l.productId}"/></td>
  <td> <c:out value="${l.productName}"/></td>
	
   </table> -->
   
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
							</c:forEach></td>
							
					</tr>
					<tr>
						<td><c:out value="${l.ProductName}"/></td>
					</tr>
				</table>
				 
		
		</div>
</c:forEach>
</body>
</html>