<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<%@page import="java.util.List"%>
<%@page import="orm.Contacto" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda Simple</title>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
<script type="text/javascript" src="./js/fotoSrt.js"></script>
</head>
<body>
<h2 >Búsqueda simple</h2>
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
		<th>teléfono</th>
		<th>mail</th>
		<th>país</th>
		<th>región</th>
		<th>ciudad</th>
		<th>fotografía</th>
		<th>nombre empresa</th>
		<th>razón social empresa</th>
		</thead>
		<tbody>
		<i:forEach items="${listaContacto}" var="contacto">
			<tr>
			<td>${contacto.uid}</td>
			<td>${contacto.nombre}</td>
			<td>${contacto.apellido}</td>
			<td>${contacto.telefono}</td>
			<td>${contacto.mail}</td>
			<td>${contacto.pais}</td>
			<td>${contacto.region}</td>
			<td>${contacto.ciudad}</td>
			<td id="fotoContainer" onLoad="decodeImage();">
			<img src="${contacto.fotoCont}" border-radius="6px" class = "img-rounded">
			</td>
			<td>${contacto.empresaUid.nombre}</td>
			<td>${contacto.empresaUid.razonSocial}</td>
		<tr/>
		</i:forEach>
		</tbody>
</table>	
	
	
</body>
</html>