<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="orm.Contacto" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BusquedaSimpleServlet" id="BusquedaSimpleServlet" method="post" class="form-horizontal mitad" action="#">
	<div class="form-group">
		<label class="col-lg-3 control-label">Buscar</label>
		<div class="col-lg-3">
			<input type="text" class="form-control" name="buscar" required>
			<br>
			<button type="submit" class="btn btn-success left">Buscar</button>
		</div>
	</div>
	</form>
	
	<table class="table table-striped">
		<thead>
		<th>id</th>
		<th>nombre</th>
		<th>apellido</th>
		<th>telefono</th>
		<th>mail</th>
		</thead>
		<tbody>
		<i:forEach items="${listaContacto}" var="contacto">
			<td>${contacto.uid}</td>
			<td>${contacto.nombre}</td>
			<td>${contacto.apellido}</td>
			<td>${contacto.telefono}</td>
			<td>${contacto.mail}</td>
		<br />
		</i:forEach>
		</tbody>
</table>	
	
	
</body>
</html>