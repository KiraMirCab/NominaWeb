<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú de Opciones</title>
</head>
<body>
<h1>Menu de Opciones Nominas</h1>
<table border="1">
  <tr>
    <td><a href="empleados?opcion=alta"> Dar de alta un empleado</a></td>
  </tr>
  <tr>
    <td><a href="empleados?opcion=listar"> Listar empleados</a></td>
  </tr>
   <tr>
    <td>
    Actualizar los datos de un empleado.
    <form >
    	<label>DNI</label>
    	<input type="text" name="dni" size="50">
    	<a href="empleados?opcion=meditar&dni=${dni}">
        	Actualizar
      	</a>
    </form>    
   </td>
  </tr>
</table>
</body>
</html>