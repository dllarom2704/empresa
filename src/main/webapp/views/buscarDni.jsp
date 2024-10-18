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
		<header>
			<h2>Nóminas</h2>
			<nav>
				<ul>
					<li><a href="productos?opcion=index">Inicio</a></li>
					<li><a href="productos?opcion=listar">Listar</a></li>
					<li><a href="productos?opcion=editar">Editar</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<h1>Mostrar salrio de un empleado</h1>
			<form action="productos" method="post">
				<fieldset>
					<label for="dni">Introduce el DNI</label>
					<input type="text" name="dni" id="dni">
				</fieldset>
				<button>Buscar</button>
			</form>
			<h2>Salario</h2>
		</main>
	</div>
</body>
</html>