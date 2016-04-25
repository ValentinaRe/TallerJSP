<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="orm.Contacto" %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet"></link>
<link
	href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"
	rel="stylesheet"></link>

<script src="//oss.maxcdn.com/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>

<jsp:include page="MenuFormularios.jsp"></jsp:include>
<title>Listar Contacto</title>
</head>
<body>

	<form action="ListarServlet" method="get">
	<label>lista de contactos</label>
	<br />
	<input type="submit" value="mostrar">
	</form>
	<table class="table table-striped">
		<thead>
		<th>id</th>
		<th>nombre</th>
		<th>apellido</th>
		<th>telefono</th>
		<th>mail</th>
		<th>Empresa</th>
		</thead>
		<tbody>
		<i:forEach items="${listaContacto}" var="contacto">
			<tr>
			<td>${contacto.uid}</td>
			<td>${contacto.nombre}</td>
			<td>${contacto.apellido}</td>
			<td>${contacto.telefono}</td>
			<td>${contacto.mail}</td>
			<td>${contacto.empresaUid.rut}</td>
			
			</tr>
		<br />
		</i:forEach>
		</tbody>
		
</table>	
	
	
		
	
</body>
</html>