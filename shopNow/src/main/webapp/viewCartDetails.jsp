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

  
 
 
<!--   <table>
 <tr>
 <td> <img style="margin: 10px;"
							src="data:image/jpeg;base64,${l.base64Image}" width="240"
							height="300"  /></td>
							   <td><c:out value="${l.productId}"/></td>
  <td> <c:out value="${l.productName}"/></td>
	
   </table> -->
   
   <c:forEach var="l" items="${list1}">
  <div style="display: inline-block; text-align: center; margin: 10px;">
			
				<table>
					<tr>
					  
						<td>
						
						 <a href="productDetails?productId=${l.productId}">
						 <img style="margin: 10px;"
							src="data:image/jpeg;base64,${l.base64Image}" width="240"
							height="300"  />
							</a>
						
							
							</td>
								<tr>
							<td><c:out value="${l.productName}"/></td></tr>
							<tr>
							<td><c:out value="${l.productPrice}"/>/- for 1 Iteam</td></tr>
							<tr><td> Qt : <c:out value="${l.count}"/> price for <c:out value="${l.productPrice*l.count}"/>/-</td>
					</tr>	
							
				 
					</tr>
					
				</table>
		
		</div>
		
		</c:forEach>
		

</body>
</html>