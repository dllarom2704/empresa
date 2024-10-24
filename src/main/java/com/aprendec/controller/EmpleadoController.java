package com.aprendec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aprendec.dao.EmpleadoDAO;
import com.aprendec.model.Empleado;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla empleados", urlPatterns = { "/empleados" })
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
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar")) {

			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			List<Empleado> lista = new ArrayList<>();
			try {
				lista = empleadoDAO.obtenerEmpleados();
				for (Empleado empleado : lista) {
					System.out.println(empleado);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");

		} else if (opcion.equals("buscarDni")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarDni.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("salario")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/salario.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("buscarDato")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarDato.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("editar")) {
			String dni = request.getParameter("dni");
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			Empleado empleado = new Empleado();

			try {
				empleado = empleadoDAO.obtenerEmpleado(dni);

				System.out.println(empleado);

				request.setAttribute("empleado", empleado);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opcion.equals("volver")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");

		if (opcion.equals("buscarDni")) {
			Empleado empleado = new Empleado();
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();

			empleado.setDni(request.getParameter("dni"));

			try {
				String salario = empleadoDAO.getSalario(empleado.getDni());
				System.out.println(salario);
				request.setAttribute("salario", salario);

				System.out.println("Búsqueda realizada");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/salario.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("buscarDato")) {
			Empleado empleado = new Empleado();
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();

			String datum = request.getParameter("datum");
			List<Empleado> empleados = null;
			try {
				empleados = empleadoDAO.getEmpleadoData(datum);
				request.setAttribute("listaEmpleados", empleados);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < empleados.size(); i++) {
				empleados.get(i).imprime();
			}

			System.out.println("Búsqueda realizada");

			RequestDispatcher requestDispacher = request
					.getRequestDispatcher("/views/listarEmpleadosBusquedaDatos.jsp");
			requestDispacher.forward(request, response);

		} else if (opcion.equals("editar")) {
			Empleado empleado = new Empleado();
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();

			empleado.setNombre(request.getParameter("nombre"));
			empleado.setDni(request.getParameter("dni"));
			empleado.setSexo(request.getParameter("sexo").charAt(0));
			empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
			empleado.setCategoria(Integer.parseInt(request.getParameter("anyos")));

			try {
				empleadoDAO.editar(empleado);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarDato.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//			doGet(request, response);
	}

}
