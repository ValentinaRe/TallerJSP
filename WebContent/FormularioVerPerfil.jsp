<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
  <form action="Perfil" method="get">
	<label>lista de contactos</label>
	<br />
	

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
		
		
		
			<tr>
			
			<td>${contacto.nombre}</td>
			<td>${contacto.apellido}</td>
			<td>${contacto.telefono}</td>
			<td>${contacto.mail}</td>
			<td id="fotoContainer" onLoad="decodeImage();">
			<img src="${contacto.fotoCont}" style="border-radius:6px%;" class = "img-rounded">
			</td>
			<td>${contacto.empresaUid.rut}</td>
			
			
			<td>		
	</form>
</body>
</html>