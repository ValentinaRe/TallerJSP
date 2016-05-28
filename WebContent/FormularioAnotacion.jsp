<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="MenuFormularios.jsp"></jsp:include>
</head>
<body>
<%String idContacto =request.getParameter("idContacto"); %>
<div class="container">
<div class="page-header">
<h2 >Ingrese Comentario </h2>
</div>


	<form id="AnotacionServlet" action="AnotacionServlet" method="POST"
		class="form-horizontal mitad" >
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese nombre</label>
			<div class="col-lg-3">
				<input type="text" class="form-control"  name="nombre" > <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label">Ingrese Descripcion</label>
			<div class="col-lg-3">
				<textarea  class="form-control" rows="10" cols="30" name="descripcion" ></textarea> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="col-lg-3 control-label"></label>
			<div class="col-lg-3">
				<input type="hidden" class="form-control"  name="idContacto" value="<%=idContacto%>" > <br>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-lg-9 col-lg-offset-3">
				<button type="submit" class="btn btn-success left" >Enviar</button>
			</div>
		</div>
	</form>
	
		
</div>

</body>
</html>