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
			resultSet = statement.executeQuery();
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
			sql = "SELECT sueldo FROM nominas WHERE dni = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);
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

	public static List<Empleado> getEmpleadoData(String datum) throws SQLException {
		ResultSet resultSet = null;

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		List<Empleado> empleados = new ArrayList<>();

		try {
			try {
				sql = "SELECT * FROM empleados WHERE nombre LIKE ? OR dni LIKE ? OR sexo = ? OR categoria = ? OR anyos = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, "%" + datum + "%");
				statement.setString(2, "%" + datum + "%");
				statement.setString(3, String.valueOf(datum.charAt(0)));
				statement.setInt(4, Integer.parseInt(datum));
				statement.setInt(5, Integer.parseInt(datum));
				resultSet = statement.executeQuery();
			} catch (NumberFormatException e) {
				sql = "SELECT * FROM empleados WHERE nombre LIKE ? OR dni LIKE ? OR sexo = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, "%" + datum + "%");
				statement.setString(2, "%" + datum + "%");
				statement.setString(3, String.valueOf(datum.charAt(0)));
				resultSet = statement.executeQuery();
			}

			while (resultSet.next()) {
				Empleado e = new Empleado();
				e.setNombre(resultSet.getString("nombre"));
				e.setDni(resultSet.getString("dni"));
				e.setSexo(resultSet.getString("sexo").charAt(0));
				e.setCategoria(resultSet.getInt("categoria"));
				e.setAnyos(resultSet.getInt("anyos"));
				empleados.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleados;
	}

	public Empleado obtenerEmpleado(String dni) throws SQLException {
		ResultSet resultSet = null;
		Empleado e = new Empleado();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM empleados WHERE dni = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				e.setNombre(resultSet.getString(1));
				e.setDni(resultSet.getString(2));
				e.setSexo(resultSet.getString(3).charAt(0));
				e.setCategoria(resultSet.getInt(4));
				e.setAnyos(resultSet.getInt(5));
			}

		} catch (SQLException error) {
			error.printStackTrace();
		}

		return e;
	}

	public boolean editar(Empleado empleado) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE empleados SET nombre = ?, dni = ?, sexo = ?, categoria = ?, anyos = ? WHERE dni = ?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getDni());
			statement.setLong(3, empleado.getSexo());
			statement.setInt(4, empleado.getCategoria());
			statement.setInt(5, empleado.getAnyos());
			statement.setString(6, empleado.getDni());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener conexion pool
	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}