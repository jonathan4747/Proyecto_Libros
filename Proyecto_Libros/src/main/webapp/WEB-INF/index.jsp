<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Reading Books</title>
	</head>
	<body>
	<h1> <c:out value="${titulo}"/></h1>
	<p>Descipción: <c:out value="${descripcion}"/></p>
	<p>Lenguaje: <c:out value="${lenguaje}"/></p>
	<p>Numero de Paginas: <c:out value="${paginas}"/></p>
	</body>
</html>