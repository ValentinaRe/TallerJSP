<%@page import="capanegocio.Contacto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script type="text/javascript" src="./js/fotoSrt.js"></script>

<title>Listar Contacto</title>
</head>
<body>

	<form action="ListarServlet" method="get">
		<label>lista de contactos</label> <br /> <input type="submit"
			value="mostrar">
	</form>
	<table class="table table-striped">
		<thead>

			<th>nombre</th>
			<th>apellido</th>
			<th>teléfono</th>
			<th>mail</th>
			<th>fotografía</th>
			<th>Empresa</th>
		</thead>
		<tbody>


			<i:forEach items="${listaContacto}" var="contacto">
				<tr>

					<td>${contacto.nombre}</td>
					<td>${contacto.apellido}</td>
					<td>${contacto.telefono}</td>
					<td>${contacto.mail}</td>
					<td id="fotoContainer" onLoad="decodeImage();">
						<img src="${contacto.fotoCont}" style="border-radius: 6px%;"
							class="img-rounded"></td>
					<td>${contacto.empresaUid.rut}</td>
					
					<td>	
						<form action="FormularioAnotacion.jsp" method="POST">
							<input type="hidden" value="${contacto.uid}" name="idContacto">
							<input type="submit" value="Agregar comentario"
								class="btn btn-primary btn-filter"> 
						</form>
					</td>
					
					<td>
						<form action="EliminarServlet" method="post">
							<input type="hidden" value="${contacto.uid}" name="id"> <input
								type="submit" value="Eliminar" class="btn btn-danger">

						</form>
					</td>
					
					<td>
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
							<input type="submit" value="Actualizar Contacto" class="btn btn-warning">
						</form>

					</td>

					
				</tr>
			</i:forEach>
		</tbody>

	</table>

</body>
</html>