<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
  <div style="color:red">${error}</div>
  <form action="UpdateBookServlet" method="post">
    <table>
      <tr>
        <td></td>
        <td><input type="hidden" name="id" value="${bean.id}"/></td>
        
      </tr>
      
      <tr>
        <td>Name</td>
        <td><input type="text" name="name" value="${bean.name}"/></td>
         <td><form:errors path="name" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td>Author</td>
        <td><input type="text" name="author" value="${bean.author}"/></td>
         <td><form:errors path="author" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td>Price</td>
        <td><input type="number" name="price" value="${bean.price}"/></td>
         <td><form:errors path="price" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td></td>
        <td><input type="submit" value="Update"/></td>
      </tr>
    </table>
  </form>
</body>
</html>