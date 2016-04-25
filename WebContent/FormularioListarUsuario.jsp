<%@page import="java.util.List"%>
<%@page import="orm.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
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
<title>Listar Usuario</title>
</head>
<body>


</head>
<body>

	<form action="ListarUsuarioServlet" method="get">
	<label>lista de usuarios</label>
	<br />
	<input type="submit" value="mostrar">
	</form>
	<table class="table table-striped">
		<thead>
		<th>user</th>
		<th>password</th>
		
		</thead>
		<tbody>
		<i:forEach items="${listaContacto}" var="usuario">
			<tr>
			<td>${usuario.user}</td>
			<td>${usuario.pass}</td>
					<td>
						<form action="EliminarUsuarioServlet" method="post">
							<input type="hidden" value="${usuaro.uid}" name="id">
							<input type="submit" value="Eliminar" class="btn btn-danger">	
						</form>
					</td>	
			</tr>
		<br />
		</i:forEach>
		</tbody>
		
</table>	
	
	
</body>
</html>