<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.error
	{
	color: #ff000;
	}
	.errorblock
	{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
	}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="color:red">${error}</div>
  
  <form:form action="/bookmanagement_crud_with_spring/addbook" method="post" modelAttribute="bean">
  <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
      
      <tr>
        <td>Name</td>
        <td><form:input type="text" path="name"/></td>
        <td><form:errors path="name" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td>Author</td>
        <td><form:input type="text" path="author"/></td>
         <td><form:errors path="author" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td>Price</td>
        <td><form:input type="number" path="price"/></td>
         <td><form:errors path="price" cssClass="error"/></td>
      </tr>
      <tr>
      	<td></td>
      	<td><input type="submit" value="Add"/></td>
      </tr>
    </table>
  </form:form>
</body>
</html>