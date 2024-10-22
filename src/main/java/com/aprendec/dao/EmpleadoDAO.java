package com.aprendec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aprendec.conexion.Conexion;
import com.aprendec.model.Empleado;

public class EmpleadoDAO {
	private static Connection connection;
	private static PreparedStatement statement;
	private static boolean estadoOperacion;

	// obtener lista de productos
	public List<Empleado> obtenerEmpleados() throws SQLException {
		ResultSet resultSet = null;
		List<Empleado> listaEmpleados = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM empleados";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Empleado e = new Empleado();
				e.setNombre(resultSet.getString(1));
				e.setDni(resultSet.getString(2));
				e.setSexo(resultSet.getString(3).charAt(0));
				e.setCategoria(resultSet.getInt(4));
				e.setAnyos(resultSet.getInt(5));
				listaEmpleados.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaEmpleados;
	}

	public static String getSalario(String dni) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		String salario = null;

		try {
			sql = "SELECT sueldo FROM nominas WHERE dni = '" + dni + "'";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				System.out.println("Has next");
				salario = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salario;

	}

	public static void getEmpleadoData(String datum) throws SQLException {
		ResultSet resultSet = null;

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		List<Empleado> empleados = new ArrayList<>();

		try {
			sql = "SELECT * FROM empleados WHERE nombre = '" + datum + "' OR dni = '" + datum + "' OR sexo = '"
					+ datum.charAt(0) + "' OR categoria = " + Integer.parseInt(datum) + " OR anyos = "
					+ Integer.parseInt(datum);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			System.out.println(resultSet);
			while (resultSet.next()) {
				Empleado e = new Empleado();
				e.setNombre(resultSet.getString("nombre"));
				e.setDni(resultSet.getString("dni"));
				e.setSexo(resultSet.getString("sexo").charAt(0));
				e.setCategoria(resultSet.getInt("categoria"));
				e.setAnyos(resultSet.getInt("anyos"));
				empleados.add(e);
			}

			System.out.println(empleados);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// obtener conexion pool
	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}