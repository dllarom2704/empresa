<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Empleado</title>
<link rel="stylesheet" href="./assets/styles/style.css">
</head>
<body>
	<div id="container">
		<p class="btn">
			<a href="empleados?opcion=volver">Volver</a>
		</p>
		<main>
			<div>
				<h1>Editar Empleado</h1>
				<form action="empleados" method="post">
					<c:set var="empleado" value="${empleado}"></c:set>
					<input type="hidden" name="opcion" value="editar"> <input
						type="hidden" name="dniEmpleadoBuscado" value="${empleado.dni}">
					<fieldset>
						<label for="nombre">Nuevo Nombre</label> <input type="text"
							name="nombre" id="nombre" value="${ empleado.nombre}">
					</fieldset>
					<fieldset>
						<label for="dni">Nuevo DNI</label> <input type="text" name="dni"
							id="dni" value="${ empleado.dni}">
					</fieldset>
					<fieldset>
						<label for="sexo">Nuevo Sexo</label> <input type="text"
							name="sexo" id="sexo" value="${ empleado.sexo}">
					</fieldset>
					<fieldset>
						<label for="categoria">Nueva Categoría</label> <input type="text"
							name="categoria" id="categoria" value="${ empleado.categoria}">
					</fieldset>
					<fieldset>
						<label for="anyos">Nuevos Años</label> <input type="text"
							name="anyos" id="anyos" value="${ empleado.anyos}">
					</fieldset>
					<button type="submit">Editar</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>