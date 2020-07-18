<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
<spring:url value="/resources" var="urlPublic" />
</head>
<body>
	<h1>Lista de Peliculas</h1>
	<ol>
		<c:forEach items="${ peliculas }" var="pelicula">
			<li> ${pelicula} </li>
		</c:forEach>
	</ol>

	Tabla de peliculas
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Duración</th>
				<th>Clasificación</th>
				<th>Genero</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${peliculas}" var="pelicula">
				<tr>
					<td>${pelicula.id}</td>
					<td>${pelicula.titulo}</td>
					<td>${pelicula.duracion}. min</td>
					<td>${pelicula.clasificacion}</td>
					<td>${pelicula.genero}</td>
					<td><img src="${urlPublic}/images/${pelicula.imagen}"></td>
					<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
					<td>
						<c:choose>
							<c:when test="${pelicula.estatus == 'Activa'}">
								<span class="label label-success">Activa</span>
							</c:when>
							<c:otherwise>
								<span class="label label-danger">Inactiva</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>