<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar empleados</title>
</head>
<body>
<a href="empleados?opcion=volver"><button> Volver </button></a>
	<h1>Buscar empleados</h1>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="buscarEmpleadosDNI">
		<label>por DNI: </label> <br>
		<input type="text" name="dni" size="50">
		<input type="submit" value="Buscar">
	</form>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="buscarEmpleadosNombre">
		<label>por nombre: </label> <br>
		<input type="text" name="nombre" size="50">
		<input type="submit" value="Buscar">
	</form>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="buscarEmpleadosSexo">
		<label>por sexo ("M" o "H"): </label> <br>
		<input type="text" name="sexo" size="50"> 
		<input type="submit" value="Buscar">
	</form>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="buscarEmpleadosCategoria">
		<label>por categoria: </label> <br>
		<input type="text" name="categoria" size="50"> 
		<input type="submit" value="Buscar">
	</form>
	<form action="empleados" method="post">
		<input type="hidden" name="opcion" value="buscarEmpleadosAnyos">
		<label>por años trabajados: </label> <br> 
		<input type="text" name="anyos" size="50"> 
		<input type="submit" value="Buscar">
	</form>
</body>
</html>