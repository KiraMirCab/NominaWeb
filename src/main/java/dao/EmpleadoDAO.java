package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.conexion;
import exceptions.DatosNoCorrectosException;
import model.Empleado;
import model.Nomina;

public class EmpleadoDAO {
	
	 private Connection connection;
	 private PreparedStatement st;
	 private ResultSet rs;
	 
/**
 * Este método inserta un nuevo empleado en la tabla de los datos de empleados e
 * inserta su correspondiente salario en la tabla nominas
 * 
 * @param Empleado
 */
public void altaEmpleado(Empleado emp) {
	String sql = null;	
	
	try {
		connection = obtenerConexion();
		connection.setAutoCommit(false);
		sql = "INSERT INTO empleados (dni, nombre, sexo, categoria, anyos) VALUES (?, ?, ?, ?, ?)";
		st = connection.prepareStatement(sql);
		st.setString(1, emp.getDni());
		st.setString(2, emp.getNombre());
		st.setString(3, String.valueOf(emp.getSexo()));
		st.setInt(4, emp.getCategoria());
		st.setInt(5, emp.getAnyos());

		int numFilas = st.executeUpdate();
		System.out.println(numFilas + " filas insertadas en la tabla Empleados");

		st = connection.prepareStatement("INSERT INTO nominas (dni, sueldo) VALUES (?, ?)");
		st.setString(1, emp.getDni());
		st.setInt(2, Nomina.sueldo(emp));
		numFilas = st.executeUpdate();
		System.out.println(numFilas + " filas insertadas en la tabla Nominas");
		
		connection.commit();
		st.close();
		connection.close();
	  } catch (SQLException e) {
		  try{
			  System.out.println("Ocurrió algún error al conectar u operar con la BD");
			  connection.rollback();
			  e.printStackTrace();
		  } catch (SQLException e1) {
			  System.out.println("Ocurrió algún error al hacer rollback");
			  e.printStackTrace();
		  }
	  }	
}

/**
 * Este método convierte el contenido de la tabla Empleados en objetos
 * @return array list de empleados
 */
public ArrayList<Empleado> leeTablaEmpleados() {
	
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	try {
		connection = obtenerConexion();
		connection.setAutoCommit(false);
		st = connection.prepareStatement("SELECT dni, nombre, sexo, categoria, anyos FROM empleados;");
		rs = st.executeQuery();

		while (rs.next()) {
			String dni = rs.getString(1);
			String nombre = rs.getString(2);
			char sexo = rs.getString(3).charAt(0);
			int categoria = rs.getInt(4);
			int anyos = rs.getInt(5);
			Empleado emp = new Empleado(dni, nombre, sexo, categoria, anyos);
			empleados.add(emp);
		}
	} catch (DatosNoCorrectosException e) {
		System.out.println("Datos incorrectos, no se puede crear un empleado");
	} catch (SQLException e) {
		try {
			System.out.println("Ocurrió algún error al conectar u operar con la BD");
			connection.rollback();
			e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("Ocurrió algún error al hacer rollback");
				e.printStackTrace();
			}
	}
	return empleados;
}

/**
 * Este método encuentra el empleado en la tabla por el dni y actualiza los datos del empleado
 * en las dos tablas
 * @param empleado
 */
public void actualizaEmpleado(Empleado emp) {
	try {
		connection = obtenerConexion();
		connection.setAutoCommit(false);
		st = connection.prepareStatement("UPDATE empleados SET nombre = '" + emp.getNombre() + "', sexo = '" +
				emp.getSexo() + "', categoria = '" + emp.getCategoria() + "', anyos = '" + emp.getAnyos() + 
				"' WHERE dni = '" + emp.getDni() + "'");
		
		int numFilas = st.executeUpdate();
		System.out.println(numFilas + " filas de la tabla Empleado actualizadas");
		
		st = connection.prepareStatement("UPDATE nominas SET sueldo = '" + Nomina.sueldo(emp) + 
				"' WHERE dni = '" + emp.getDni() + "'");
		
		numFilas = st.executeUpdate();
		System.out.println(numFilas + " filas de la tabla Nominas actualizadas");


	 } catch (SQLException e) {
		  try{
			  System.out.println("Ocurrió algún error al conectar u operar con la BD");
			  connection.rollback();
			  e.printStackTrace();
		  } catch (SQLException e1) {
			  System.out.println("Ocurrió algún error al hacer rollback");
			  e.printStackTrace();
		  }
	  }	
}

//obtener conexion
private Connection obtenerConexion() throws SQLException {
return conexion.getConnection();
}
}
