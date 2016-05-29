<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<jsp:include page="MenuFormularios.jsp"></jsp:include>
<title>Ver perfil</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="page-header">
				<form action="Perfil" method="get">
					<h2>Lista de contactos</h2>
					<br />
				</form>
			</div>
			<table class="table table-striped">
				<thead>
					<tr class=success>
						<th>run</th>
						<th>nombre</th>
						<th>apellido</th>
						<th>teléfono</th>
						<th>mail</th>
						<th>pais</th>
						<th>region</th>
						<th>ciudad</th>
						<th>fotografía</th>
						<th>Empresa</th>
					</tr>
				</thead>

				<tbody>

					<tr>
						<td>${contacto.run}</td>
						<td>${contacto.nombre}</td>
						<td>${contacto.apellido}</td>
						<td>${contacto.telefono}</td>
						<td>${contacto.mail}</td>
						<td>${contacto.pais}</td>
						<td>${contacto.region}</td>
						<td>${contacto.ciudad}</td>
						<td id="fotoContainer" onLoad="decodeImage();"><img
							src="${contacto.fotoCont}" style="border-radius: 6px%;"
							class="img-rounded"></td>
						<td>${contacto.empresaUid.rut}</td>


						<td></td>
				</tbody>
			</table>
		</div>
			<h3 class="text-danger">${Status}</h3>
	</div>

</body>
</html>