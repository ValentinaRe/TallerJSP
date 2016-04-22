<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Empresa</title>
</head>
<body>
<%@page import="java.util.List"%>
<%@page import="orm.Empresa" %>
<% List<Empresa> lista = (List<Empresa>)request.getAttribute("ListaEmpresa");%>
	<form action="ListarEmpresaServlet" method="get">
	<label>lista de empresas</label>
	<br />
	<input type="submit" value="mostrar">
		<i:forEach items="${lista}" var="empresa">
			${empresa.nombre}:${empresa.ciudad}:${empresa.direcciom}:${empresa.pais}
		<br />
		</i:forEach>
	</form>
</body>
</html>