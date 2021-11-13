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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		RequestDispatcher rd;
		EmpleadoDAO empDAO;
		ArrayList<Empleado> empleados;

		switch (opcion) {
		case ("alta"):
			System.out.println("Usted a presionado la opcion dar de alta un empleado");
			rd = request.getRequestDispatcher("/views/alta.jsp");
			rd.forward(request, response);
			break;

		case ("verSalario"):
			System.out.println("Usted a presionado la opcion ver el salario de un empleado");
			rd = request.getRequestDispatcher("/views/verSalario.jsp");
			rd.forward(request, response);
			break;

		case ("buscar"):
			System.out.println("Usted a presionado la opcion buscar empleados");
			rd = request.getRequestDispatcher("/views/buscarEmpleados.jsp");
			rd.forward(request, response);
			break;

//		case ("listarPorNombre"):
//			System.out.println("Usted a presionado la opcion listar por nombre");
//			empDAO = new EmpleadoDAO();
//			empleados = new ArrayList<>();
//			ArrayList<Empleado> empleadosNombre = new ArrayList<>();
//			empleados = empDAO.leeTablaEmpleados();
//			for (Empleado emp : empleados)
//				if (emp.getNombre().equalsIgnoreCase(nombre)) {
//					empleadosNombre.add(emp);
//				}
//			request.setAttribute("empleados", empleadosNombre);
//			rd = request.getRequestDispatcher("/views/listar.jsp");
//			rd.forward(request, response);
//			break;

		case ("actualizar"):
			System.out.println("Usted ha elegido la opcion de actualizar los datos de un empleado");
			rd = request.getRequestDispatcher("/views/actualizar.jsp");
			rd.forward(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		RequestDispatcher rd;
		EmpleadoDAO empDAO;
		ArrayList<Empleado> empleados;
		Empleado emp;

		switch (opcion) {
		case ("alta"):
			empDAO = new EmpleadoDAO();
			String dni = request.getParameter("dni");
			String nombre = request.getParameter("nombre");
			char sexo = request.getParameter("sexo").charAt(0);
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int anyos = Integer.parseInt(request.getParameter("anyos"));

			try {
				emp = new Empleado(dni, nombre, sexo, categoria, anyos);
				empDAO.altaEmpleado(emp);
				rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} catch (DatosNoCorrectosException e) {
				System.out.println("No se ha podido crear un empleado");
				e.printStackTrace();
			}
			break;

		case ("listar"):
			System.out.println("Usted a presionado la opcion listar a todos los empleados");
			empDAO = new EmpleadoDAO();
			empleados = new ArrayList<>();
			empleados = empDAO.leeTablaEmpleados();
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;

		case ("actualizar"):
			empDAO = new EmpleadoDAO();

			dni = request.getParameter("dni");
			nombre = request.getParameter("nombre");
			sexo = request.getParameter("sexo").charAt(0);
			categoria = Integer.parseInt(request.getParameter("categoria"));
			anyos = Integer.parseInt(request.getParameter("anyos"));

			try {
				emp = new Empleado(nombre, dni, sexo, categoria, anyos);
				empDAO.actualizaEmpleado(emp);
				System.out.println("Registro actualizado satisfactoriamente...");
				rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} catch (DatosNoCorrectosException e) {
				System.out.println("No se ha podido crear un empleado");
				e.printStackTrace();
			}
			break;

		case ("mostrarSalario"):
			dni = request.getParameter("dni");
			System.out.println("Mostrar salario del empleado con dni: " + dni);
			empDAO = new EmpleadoDAO();
			int salario = empDAO.getSalario(dni);
			System.out.println(salario);
			request.setAttribute("dni", dni);
			request.setAttribute("salario", salario);
			rd = request.getRequestDispatcher("/views/mostrarSalario.jsp");
			rd.forward(request, response);
			break;

		case ("buscarEmpleadosDNI"):
			dni = request.getParameter("dni");
			emp = new Empleado();
			empleados = new ArrayList<>();
			empDAO = new EmpleadoDAO();
			emp = empDAO.buscarEmpleado(dni);
			empleados.add(emp);
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;

		case ("buscarEmpleadosNombre"):
			nombre = request.getParameter("nombre");
			empleados = new ArrayList<>();
			empDAO = new EmpleadoDAO();
			empleados = empDAO.buscarEmpleadoNombre(nombre);
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;

		case ("buscarEmpleadosSexo"):
			String sex = request.getParameter("sexo");
			empleados = new ArrayList<>();
			empDAO = new EmpleadoDAO();
			empleados = empDAO.buscarEmpleadoSexo(sex);
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;

		case ("buscarEmpleadosCategoria"):
			categoria = Integer.parseInt(request.getParameter("categoria"));
			empleados = new ArrayList<>();
			empDAO = new EmpleadoDAO();
			empleados = empDAO.buscarEmpleadoCategoria(categoria);
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;

		case ("buscarEmpleadosAnyos"):
			anyos = Integer.parseInt(request.getParameter("anyos"));
			empleados = new ArrayList<>();
			empDAO = new EmpleadoDAO();
			empleados = empDAO.buscarEmpleadoAnyos(anyos);
			request.setAttribute("empleados", empleados);
			rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);
			break;
		}
	}
}
