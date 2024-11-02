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

<title>nuevo autor</title>
</head>
<body>


	<%
	String url = "http://localhost:8081/proyectwebGB/";
	%>
	<div class= "container">
	<h3>Nuevo Autor</h3>

	<form role="form" action="<%=url%>AutoresController" method="POST">
        <div class="mb-3">
		<input type="hidden" name="op" value="insertar"> 
		<label form ="nombre">Nombre del autor</label> <input type="text"
			name="nombre" id="nombre"> <br>
	</div>
	<div class="mb-3">
			   <label form ="nacionalidad">Nacionalidad</label>
			   <input type="text" name="nacionalidad" id="nacionalidad"> <br> 
	</div>		   
			    <input class="btn btn-primary" type="submit" value="Guardar" name="guargar">
			
			 <a type="button" class="btn btn-secondary" href="<%=url%>AutoresController?op=listar"> Volver</a>

	</form>
</div>


</body>
</html>