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

<script type="text/javascript" src="./js/validator.js"></script>
<title>Ingresar Empresa</title>
</head>
<body>
<h2 >Ingrese Datos de Empresa</h2>
<form id="IngresarEmpresaServlet" action="IngresarEmpresaServlet" method="Post"
		class="form-horizontal mitad" action="#">
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Rut</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="rut" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Nombre</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="nombre" required> <br>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Ciudad</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="ciudad" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Dirección</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="direccion" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese País</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="pais" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Teléfono</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="telefono" required> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Razón Social</label>
			<div class="col-lg-3">
				<input type="text" class="form-control" name="razonSocial" required> <br>
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-9 col-lg-offset-3">
				<button type="submit" class="btn btn-success left">Enviar</button>
			</div>
		</div>
	</form>
</body>
</html>