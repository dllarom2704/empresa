<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar por datos</title>
<link rel="stylesheet" href="./assets/styles/style.css">
</head>
<body>
	<div id="container">
		<p class="btn"><a href="empleados?opcion=volver">Volver</a></p>
		<main>
			<div>
				<h1>Buscar a un empleado por cualquiera de sus datos</h1>
				<form action="empleados" method="post">
					<input type="hidden" name="opcion" value="buscarDato">
					<fieldset>
						<label for="datum">Introduce cualquier dato de un empleado</label>
						<input type="text" name="datum" id="datum">
					</fieldset>
					<button type="submit">Buscar</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>