<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar por datos</title>
</head>
<body>
	<div id="container">
		<main>
			<h1>Buscar a un empleado por cualquiera de sus datos</h1>
			<form action="empleados" method="post">
				<input type="hidden" name="opcion" value="buscarDato">
				<fieldset>
					<label for="datum">Introduce cualquier dato de un empleado</label>
					<input type="text" name="datum" id="datum">
				</fieldset>
				<button type="submit">Buscar</button>
			</form>
		</main>
	</div>
</body>
</html>