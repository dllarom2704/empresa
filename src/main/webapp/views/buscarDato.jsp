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
			<form action="#">
				<fieldset>
					<label for="dato">Introduce cualquier dato de un empleado</label>
					<input type="text" name="dato" id="dato">
				</fieldset>
				<button>Buscar</button>
			</form>
		</main>
	</div>
</body>
</html>