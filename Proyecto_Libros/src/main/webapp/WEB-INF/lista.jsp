<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Read share</title>
	</head>
	<body>
		<h1>Todos los libros</h1>
	<table>
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Titulo</th>
	            <th>Lenguaje</th>
	            <th>Numero de paginas</th>
	        </tr>
	    </thead>
	    <tbody>
	         <c:forEach var="libros" items="${listaLibros}">
	         	<tr>		
							<th><c:out value="${libros.getId() }"/></th>
							<th><c:out value="${libros.getTitulo()}"/></th> 
							<th><c:out value="${libros.getLenguaje()}"/></th> 
							<th><c:out value="${libros.getNumerodepaginas()}"/></th>
				</tr>
	         </c:forEach>
	    </tbody>
	</table>
	</body>
</html>