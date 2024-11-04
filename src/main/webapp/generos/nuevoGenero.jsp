<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.css.js">
</script>  

<title>Nuevo Genero</title>
</head>
<body>


	<%
	String url = "http://localhost:8081/proyectwebGB/";
	%>
	<div class= "container">
	<h3>Nuevo Genero</h3>

	<form role="form" action="<%=url%>GenerosController" method="POST">
        <div class="mb-3">
		<input type="hidden" name="op" value="insertar"> 
		<label form ="nombre">Nombre del Genero</label> <input type="text"
			name="nombre" id="nombre"> <br>
	</div>
	<div class="mb-3">
			   <label form ="descripcion">Descripcion</label>
			   <input type="text" name="descripcion" id="descripcion"> <br> 
	</div>		   
			    <input class="btn btn-primary" type="submit" value="Guardar" name="guargar">
			
			 <a type="button" class="btn btn-secondary" href="<%=url%>GenerosController?op=listar"> Volver</a>

	</form>
</div>


</body>
</html>