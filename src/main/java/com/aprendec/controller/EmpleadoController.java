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

			request.getParameter("datum");

			System.out.println("Búsqueda realizada");

			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/editar.jsp");
			requestDispacher.forward(request, response);

//		} else if (opcion.equals("editar")) {
//			Producto producto = new Producto();
//			ProductoDAO productoDAO = new ProductoDAO();
//
//			producto.setId(Integer.parseInt(request.getParameter("id")));
//			producto.setNombre(request.getParameter("nombre"));
//			producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
//			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
//			producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
//			try {
//				productoDAO.editar(producto);
//				System.out.println("Registro editado satisfactoriamente...");
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
//				requestDispatcher.forward(request, response);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

//			doGet(request, response);
		}

	}
}