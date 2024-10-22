<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar por dni</title>
</head>
<body>
	<div id="container">
		<main>
			<h1>Mostrar salrio de un empleado</h1>
			<form action="empleados" method="post">
				<input type="hidden" name="opcion" value="buscarDni">
				<fieldset>
					<label for="dni">Introduce el DNI</label>
					<input type="text" name="dni" id="dni">
				</fieldset>
				<button type="submit">Buscar</button>
			</form>
		</main>
	</div>
</body>
</html>