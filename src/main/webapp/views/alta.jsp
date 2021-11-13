<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta empleado</title>
</head>
<body>
<a href="empleados?opcion=volver"><button> Volver </button></a>
<h1>Dar de alta un empleado</h1>
 <form action="empleados" method="post">
  <input type="hidden" name="opcion" value="alta">
  <table border="1">
  <tr>
    <td>DNI:</td>
    <td><input type="text" name="dni" size="50"></td>
   </tr>
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50"></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td><input type="text" name="sexo" size="50"></td>
   </tr>
   <tr>
    <td>Categoría:</td>
    <td><input type="text" name="categoria" size="50"></td>
   </tr>
   <tr>
    <td>Años de antiguedad:</td>
    <td><input type="text" name="anyos" size="50"></td>
   </tr>
  </table>
  	<br>
  <input type="submit" value=" Alta">
 </form>
</body>
</html>