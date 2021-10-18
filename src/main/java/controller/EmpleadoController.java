package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDAO;
import exceptions.DatosNoCorrectosException;
import model.Empleado;

/**
 * Servlet implementation class EmpleadoController
 */
@WebServlet(description = "administra peticiones para la bd laboral", urlPatterns = { "/empleados" })
public class EmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");
		RequestDispatcher rd;
		
		switch(opcion) {
			case("alta"):
				System.out.println("Usted a presionado la opcion der de alta un empleado");
				rd = request.getRequestDispatcher("/views/alta.jsp");
				rd.forward(request, response);
		    	break;
			
			case("listar"):
				System.out.println("Usted a presionado la opcion listar a todos los empleados");
				EmpleadoDAO empDAO = new EmpleadoDAO();
				ArrayList<Empleado> empleados = new ArrayList<>();
				empleados = empDAO.leeTablaEmpleados();
				for (Empleado emp : empleados) System.out.println(emp);
				request.setAttribute("empleados", empleados);
				rd = request.getRequestDispatcher("/views/listar.jsp");
				rd.forward(request, response);
				break;
				
			case("actualizar"):
				System.out.println("Usted ha elegido la opcion de actualizar los datos de un empleado");
				rd = request.getRequestDispatcher("/views/actualizar.jsp");
				rd.forward(request, response);
		    	break;
		}
				
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		RequestDispatcher rd;
		
		switch(opcion) {
			case ("alta"):
				EmpleadoDAO empDAO = new EmpleadoDAO();
				String dni = request.getParameter("dni");
				String nombre =	request.getParameter("nombre");
				char sexo = request.getParameter("sexo").charAt(0);		
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				int anyos = Integer.parseInt(request.getParameter("anyos"));		
				
				try {
					Empleado emp = new Empleado(dni, nombre, sexo, categoria, anyos);
					empDAO.altaEmpleado(emp);
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				} catch (DatosNoCorrectosException e) {
					System.out.println("No se ha podido crear un empleado");
					e.printStackTrace();
				}
				break;
				
			case ("actualizar"):
				empDAO = new EmpleadoDAO();
				
				dni = request.getParameter("dni");
				nombre = request.getParameter("nombre");
				sexo = request.getParameter("sexo").charAt(0);		
				categoria = Integer.parseInt(request.getParameter("categoria"));
				anyos = Integer.parseInt(request.getParameter("anyos"));		
			
				try {
					Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
					empDAO.actualizaEmpleado(emp);
					System.out.println("Registro actualizado satisfactoriamente...");
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				} catch (DatosNoCorrectosException e) {
					System.out.println("No se ha podido crear un empleado");
					e.printStackTrace();
				}
				break;
				
			case("meditar"):
				dni = request.getParameter("dni");
		    	System.out.println("Editar por dni: " + dni);
		    	EmpleadoDAO emp1DAO = new EmpleadoDAO();
		    	Empleado emp = new Empleado();
		    	emp = emp1DAO.buscarEmpleado(dni);
		    	System.out.println(emp);
		    	request.setAttribute("emp", emp);
		    	rd = request.getRequestDispatcher("/views/actualizar.jsp");
		    	rd.forward(request, response);
		    	break;			
		}
	}
}
