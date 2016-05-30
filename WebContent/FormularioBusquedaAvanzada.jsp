<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<%@page import="java.util.List"%>
<%@page import="orm.Contacto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda Avanzada</title>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
<script type="text/javascript" src="./js/fotoSrt.js"></script>
</head>
<body>
	<div class=jumbotron>
		<div class="container">
			<div class=page-header>
				<h2>Búsqueda avanzada</h2>
			</div>
			<form action="BusquedaAvanzadaServlet" id="BusquedaAvanzadaServlet"
				method="post" class="form-horizontal mitad" action="#">
				<div class="form-group">
					<label class="col-lg-3 control-label">Run</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="run"> <br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Nombre</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="nombre"> <br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Apellido</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="apellido">
						<br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Mail</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="mail"> <br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Teléfono</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="telefono">
						<br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">País</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="pais"> <br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Región</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="region"> <br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Ciudad</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="ciudad"> <br>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
						<button type="submit" class="btn btn-success left">Buscar</button>
					</div>
				</div>
			</form>
			<%
				try {
					request.getAttribute("listaContacto").toString();
			%>
			<table type="hidden" class="table table-striped" id="tabla">
			
				<thead>
				<tr class="success">
					<th>nombre</th>
					<th>apellido</th>
					<th>telefono</th>
					<th>mail</th>
					<th>fotografía</th>
					<th></th>
				</tr>
				</thead>
				<tbody>
					<i:forEach items="${listaContacto}" var="contacto">
						<tr>
							<td>${contacto.nombre}</td>
							<td>${contacto.apellido}</td>
							<td>${contacto.telefono}</td>
							<td>${contacto.mail}</td>
							
							<td id="fotoContainer" onLoad="decodeImage();"><img
								src="${contacto.fotoCont}" border-radius="6px"
								class="img-rounded"></td>
							<td>
								<div>
									<form action="Perfil" method="post">
										<input type="hidden" value="${contacto.uid}" name="id">
										<input type="submit" value="ver perfil"
											class="btn btn-warning btn-filter">
									</form>
									<br>
								</div>
								<form action="AnotacionServletSet" method="POST">
									<input type="hidden" value="${contacto.uid}" name="idContacto">
									<input type="submit" value="Agregar comentario"
										class="btn btn-info">
								</form>
								<br>
						<form action="EliminarServlet" method="post">
							<input type="hidden" value="${contacto.uid}" name="id"> <input
								type="submit" value="Eliminar" class="btn btn-danger">

						</form>
					<br>
					
					
						<form action="ActualizarServletSet" method="POST">

							<input type="hidden" value="${contacto.uid}" name="id"> 
							<input type="hidden" value="${contacto.run}" name="run"> 
							<input type="hidden" value="${contacto.nombre}" name="nombre">
							<input type="hidden" value="${contacto.apellido}" name="apellido">
							<input type="hidden" value="${contacto.mail}" name="mail">
							<input type="hidden" value="${contacto.telefono}" name="telefono">
							<input type="hidden" value="${contacto.pais}" name="pais">
							<input type="hidden" value="${contacto.region}" name="region">
							<input type="hidden" value="${contacto.ciudad}" name="ciudad">
							<input type="hidden" value="${contacto.fotoCont}" name="fotoCont">
							<input type="hidden" value="${contacto.empresaUid.uid}" name="idEmpresa"> 
							<input type="submit" value="Actualizar Contacto" class="btn btn-success">
						</form>

					
							</td>
						<tr />
					</i:forEach>
				</tbody>
				</div>
			</table>
			<%
				} catch (NullPointerException e) {

				}
			%>
		</div>
		<h3 class="text-danger">${Status}</h3>
</body>
</html>