<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar por dni</title>
<link rel="stylesheet" href="./assets/styles/style.css">
</head>
<body>
	<div id="container">
		<p class="btn"><a href="empleados?opcion=volver">Volver</a></p>
		<main>
			<div>
				<h1>Mostrar salario de un empleado</h1>
				<form action="empleados" method="post">
					<input type="hidden" name="opcion" value="buscarDni">
					<fieldset>
						<label for="dni">Introduce el DNI</label> <input type="text"
							name="dni" id="dni">
					</fieldset>
					<button type="submit">Buscar</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>