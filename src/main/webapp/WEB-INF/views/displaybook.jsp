<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Book</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="color: red">${error}</div>
  <table border= "1"  >
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Author</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${list }" var="book">
      <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.price}</td>
        <td>
          <a href="updatebook/${book.id}">Update</a>|
          <a href="deletebook/${book.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>