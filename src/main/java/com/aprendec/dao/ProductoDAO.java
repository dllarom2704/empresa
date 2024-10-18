package com.aprendec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aprendec.conexion.Conexion;
import com.aprendec.model.Empleado;

public class ProductoDAO {
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
	
	public static Integer getSalario(String dni) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		Integer salario = null;

		try {
			sql = "SELECT sueldo FROM nominas where dni =?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, dni);
			resultSet = statement.executeQuery(sql);
			salario = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salario;

	}

	// obtener conexion pool
	private static Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}