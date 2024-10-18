<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
</head>
<body>
	<div>
		<h1>Listar Productos</h1>
		 <table>
		  <tr>
		   <td>Nombre</td>
		   <td>Dni</td>
		   <td>Sexo</td>
		   <td>Categoría</td>
		   <td>Años</td>
		  </tr>
		  <c:forEach var="producto" items="${lista}">
		  <tr>
		    <td><c:out value="${ producto.nombre}"></c:out></td>
		    <td><c:out value="${ producto.dni}"></c:out></td>
		    <td><c:out value="${ producto.sexo}"></c:out></td>
		    <td><c:out value="${ producto.categoria}"></c:out></td>
		    <td><c:out value="${ producto.anyos}"></c:out></td>
		  </tr>
		  </c:forEach>
		 </table>
	</div>
</body>
</html>