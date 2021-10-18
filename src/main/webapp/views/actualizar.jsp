<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar un empleado</title>
</head>
<body>
<h1>Actualizar los datos de un empleado</h1>
 <form action="empleados" method="post">
  <c:set var="emp" value="${emp}"></c:set>
  <input type="hidden" name="opcion" value="meditar">
  <table border="1">
   <tr>
    <td>DNI:</td>
    <td><input type="text" name="id" size="50" value="${emp.dni}"></td>
   </tr>
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50" value="${emp.nombre}"></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td><input type="text" name="sexo" size="50" value="${emp.sexo}"></td>
   </tr>
   <tr>
    <td>Categoría:</td>
    <td><input type="text" name="categoria" size="50" value="${emp.categoria}"></td>
   </tr>
   <tr>
    <td>Años de antigüedad:</td>
    <td><input type="text" name="anyos" size="50" value="${emp.anyos}"></td>
   </tr>
  </table>
  <input type="submit" value="actualizar">
 </form>
</body>
</html>