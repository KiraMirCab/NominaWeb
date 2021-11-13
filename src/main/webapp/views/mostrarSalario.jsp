<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salario</title>
</head>
<body>
<a href="empleados?opcion=volver"><button> Volver </button></a>
<h1>Salario del empleado</h1>
 <table border="1">
  <tr>
   <td>DNI</td>
   <td>Salario</td>
   </tr>
   <tr>
   <td style="Width: 100px"><c:out value="${ dni }"></c:out></td>
   <td style="Width: 100px"><c:out value="${ salario }"></c:out></td>
   </tr>
   </table>
</body>
</html>