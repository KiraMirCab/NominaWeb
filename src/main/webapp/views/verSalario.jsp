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
<h1>Ver salario de un empleado</h1>
<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="mostrarSalario">
    	<label>DNI</label>
    	<input type="text" name="dni" size="50">
    	<input type="submit" value="Ver">
    </form>    
</body>
</html>