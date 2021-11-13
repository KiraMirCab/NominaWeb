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
<a href="empleados?opcion=volver"><button> Volver </button></a>
<h1>Lista de todos los empleados</h1>
 <table border="1">
  <tr>
   <td>Id</td>
   <td>Nombre</td>
   <td>Sexo</td>
   <td>Categoría</td>
   <td>Años de antigüedad</td>
   <td>Acciones</td>
  </tr>
  <c:forEach var="emp" items="${empleados}">
  <tr>
    <td><c:out value="${ emp.dni }"></c:out></td>
    <td><c:out value="${ emp.nombre }"></c:out></td>
    <td><c:out value="${ emp.sexo }"></c:out></td>
    <td><c:out value="${ emp.categoria }"></c:out></td>
    <td><c:out value="${ emp.anyos }"></c:out></td>
    <td>
    	<form action="empleados" method="post">
		  <input type="hidden" name="opcion" value="mostrarSalario">
    	  <input type="hidden" name="dni" value="${ emp.dni }">
    	  <input type="submit" value="Ver Salario">
    	</form>    
    	<form action="empleados" method="post">
		  <input type="hidden" name="opcion" value="vamosAactualizar">
    	  <input type="hidden" name="dni" value="${ emp.dni }">
    	  <input type="submit" value=" Actualizar ">
    	</form>    
    </td>
  </tr>
  </c:forEach>
 </table>
</body>
</html>