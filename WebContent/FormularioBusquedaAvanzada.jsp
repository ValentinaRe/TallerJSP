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
<title>Busqueda Avanzada</title>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
</head>
<body>
	<form action="BusquedaAvanzadaServlet" id="BusquedaAvanzadaServlet" method="post" class="form-horizontal mitad" action="#">
	<div class="form-group">
		<label class="col-lg-3 control-label">Run</label>
		<div class="col-lg-3">
			<input type="text" class="form-control" name="run" >
			<br>
			</div>
			</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Nombre</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="nombre" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Apellido</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="apellido" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Mail</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="mail" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Telefono</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="telefono" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Pais</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="pais" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Region</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="region" >
			<br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ciudad</label>
			<div class="col-lg-3">
			<input type="text" class="form-control" name="ciudad" >
			<br>
			</div>
		</div>
	<div class="form-group">
		<div class="col-lg-9 col-lg-offset-3">
		<button type="submit" class="btn btn-success left">Buscar</button>
		</div>
		</div>
	</form>
	
	<table class="table table-striped">
		<thead>
		
		<th>nombre</th>
		<th>apellido</th>
		<th>telefono</th>
		<th>mail</th>
		<th>pais</th>
		<th>region</th>
		<th>ciudad</th>
		</thead>
		<tbody>
		<i:forEach items="${listaContacto}" var="contacto">
			<tr>
			<td>${contacto.nombre}</td>
			<td>${contacto.apellido}</td>
			<td>${contacto.telefono}</td>
			<td>${contacto.mail}</td>
			<td>${contacto.pais}</td>
			<td>${contacto.region}</td>
			<td>${contacto.ciudad}</td>
		<tr/>
		</i:forEach>
		</tbody>
</table>	
	
	
</body>
</html>