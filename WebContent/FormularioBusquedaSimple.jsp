<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<%@page import="java.util.List"%>
<%@page import="orm.Contacto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda Simple</title>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
<script type="text/javascript" src="./js/fotoSrt.js"></script>
</head>
<body>
	<div class=jumbotron>
		<div class="container">
			<div class="page-container">
				<h2>Búsqueda simple</h2>
			</div>
			<h3>${Status}</h3>
			<form action="BusquedaSimpleServlet" id="BusquedaSimpleServlet"
				method="post" class="form-horizontal mitad" action="#">
				<div class="form-group">
					<label class="col-lg-3 control-label">Buscar</label>
					<div class="col-lg-3">
						<input type="text" class="form-control" name="buscar" required>
						<br>
						<button type="submit" class="btn btn-success left">Buscar</button>
					</div>
				</div>
			</form>

			<%
				try {
					request.getAttribute("listaContacto").toString();
			%>
			<table class="table">
				<thead>
					<tr class="success">
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
						<th></th>
					</tr>
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
							<td id="fotoContainer"><img src="${contacto.fotoCont}"
								border-radius="6px" class="img-rounded"></td>
							<td>${contacto.empresaUid.nombre}</td>
							<td>${contacto.empresaUid.razonSocial}</td>
							<td>
								<form action="Perfil" method="post">
									<input type="hidden" value="${contacto.uid}" name="id">
									<input type="submit" value="ver perfil"
										class="btn btn-warning btn-filter">
								</form>

								<form action="AnotacionServletSet" method="POST">
									<input type="hidden" value="${contacto.uid}" name="idContacto">
									<input type="submit" value="Agregar comentario"
										class="btn btn-info">
								</form>
							
						<form action="EliminarServlet" method="post">
							<input type="hidden" value="${contacto.uid}" name="id"> <input
								type="submit" value="Eliminar" class="btn btn-danger">

						</form>
					
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
			</table>
			<%
				} catch (NullPointerException e) {

				}
			%>
		</div>
		<h3 class="text-danger">${Status}</h3>
	</div>
</body>
</html>