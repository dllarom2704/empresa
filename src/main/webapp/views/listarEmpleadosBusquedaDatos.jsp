<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
<link rel="stylesheet" href="./assets/styles/style.css">
</head>
<body>
	<div id="container">
		<p class="btn"><a href="empleados?opcion=volver">Volver</a></p>
		<main>
			<div>
				<h1>Listar Productos</h1>
				<table>
					<tr>
						<th>Nombre</th>
						<th>Dni</th>
						<th>Sexo</th>
						<th>Categoría</th>
						<th>Años</th>
					</tr>
					<c:forEach var="empleado" items="${listaEmpleados}">
						<tr>
							<td><c:out value="${ empleado.nombre}"></c:out></td>
							<td><c:out value="${ empleado.dni}"></c:out></td>
							<td><c:out value="${ empleado.sexo}"></c:out></td>
							<td><c:out value="${ empleado.categoria}"></c:out></td>
							<td><c:out value="${ empleado.anyos}"></c:out></td>
							<td><a href="empleados?opcion=editar&dni=<c:out value="${ empleado.dni}"></c:out>">Editar</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</main>
	</div>
</body>
</html>