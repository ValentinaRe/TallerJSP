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

<script type="text/javascript" src="./js/validator.js"></script>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
<title>Ingresar Contacto</title>
</head>
<body>
<h2 >Ingrese Datos de Contacto</h2>
	<form id="TallerServlet" action="TallerServlet" method="Post"
		class="form-horizontal mitad" action="#">
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Run</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Run" name="run" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Nombre</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Apellido</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Apellido" name="apellido" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Mail</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Mail" name="mail" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Telefono</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Telefono" name="telefono" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Pa�s</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Pais" name="pais" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Regi�n</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" placeholder="Ingrese Region" name="region" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Ciudad</label>
			<div class="col-lg-3">
				<input type="text" class="form-control"  placeholder="Ingrese Ciudad" name="ciudad" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Seleccione Empresa</label>
			<div class="col-lg-3">
		    <select name="idEmpresa">
	 		 <option value=1>Volvo</option>
 		 	 <option value=2>Saab</option>
 			 <option value=3>Mercedes</option>
			 </select>
		    	</div>
		</div>
		<div class="form-group">
			<div class="col-lg-9 col-lg-offset-3">
				<button type="submit" class="btn btn-success left">Enviar</button>
			</div>
		</div>
	
</body>

</html>