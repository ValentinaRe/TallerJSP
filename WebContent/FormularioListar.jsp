<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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

<%@page import="java.util.List"%>
<%@page import="orm.Contacto" %>
<% List<Contacto> lista = (List<Contacto>)request.getAttribute("ListaContacto");%>
	<form action="ListarServlet" method="get">
	<label>lista de contactos</label>
	<br />
	<input type="submit" value="mostrar">
		<i:forEach items="${lista}" var="contacto">
			${contacto.nombre}:${contacto.apellido}:${contacto.telefono}:${contacto.mail}
		<br />
		</i:forEach>
	</form>
</body>
</html>