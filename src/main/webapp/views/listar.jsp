<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empleados</title>
</head>
<body>
<h1>Lista de todos los empleados</h1>
 <table border="1">
  <tr>
   <td>Id</td>
   <td>Nombre</td>
   <td>Sexo</td>
   <td>Categoría</td>
   <td>Años de antigüedad</td>
  </tr>
  <c:forEach var="emp" items="${empleados}">
  <tr>
    <td><c:out value="${ emp.dni }"></c:out></td>
    <td><c:out value="${ emp.nombre }"></c:out></td>
    <td><c:out value="${ emp.sexo }"></c:out></td>
    <td><c:out value="${ emp.categoria }"></c:out></td>
    <td><c:out value="${ emp.anyos }"></c:out></td>
  </tr>
  </c:forEach>
 </table>
</body>
</html>