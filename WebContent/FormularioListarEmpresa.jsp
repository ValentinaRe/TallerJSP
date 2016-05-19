 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="MenuFormularios.jsp"></jsp:include>
<title>Listar Empresa</title>
</head>
<body>
<%@page import="java.util.List"%>
<%@page import="orm.Empresa" %>

	<form action="ListarEmpresaServlet" method="get">
	<label>lista de empresa</label>
	<br/>
	<input type="submit" value="mostrar">
	</form>
	<table class="table table-striped">
		<thead>
		
		<th>nombre</th>
		<th>apellido</th>
		<th>teléfono</th>
		<th>mail</th>
		
		</thead>
		<tbody>
		<i:forEach items="${listaEmpresa}" var="empresa">
			<tr>
			<td>${empresa.rut}</td>
			<td>${empresa.nombre}</td>
			
			<td>${empresa.ciudad}</td>
			<td>${empresa.pais}</td>
			
			
			<br />
		</i:forEach>
		</tbody>
	
</table>	
</body>
</html>