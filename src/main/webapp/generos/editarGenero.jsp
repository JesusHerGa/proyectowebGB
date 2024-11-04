<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unu.proyectwebGB.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.css.js">
</script>

<title>Editar Genero</title>
</head>
<body>


	<%
	String url = "http://localhost:8081/proyectwebGB/";
	Genero genero;
	if(request.getAttribute("genero")== null)
		genero = new Genero();
	else{
		genero = (Genero)request.getAttribute("genero");
		System.out.println(genero.getIdGenero());
		System.out.println(genero.getNombre());
		System.out.println(genero.getDescripcion());

	}
	
	%>
	
	<div class= "container">
	<h3>Editar Genero</h3>

	<form role="form" action="<%=url%>GenerosController" method="POST">

		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="id" value="<%=genero.getIdGenero()%>">
		 <label	form ="nombre">Nombre del Genero</label> 
			<input type="text"	name="nombre" id="nombre" value="<%=genero.getNombre() %>"/> <br> 
			
			<label form ="descripcion" >Descripcion </label> 
			
			<input type="text"name="descripcion" id="descripcion" value="<%=genero.getDescripcion()%>"> <br> 
			
			<input type="submit" class="btn btn-primary" value="Guardar" name="Guardar">
			
			 <a type="button" class="btn btn-secondary" href="<%=url%>GenerosController?op=listar"> Volver</a>

	</form>
</div>

</body>
</html>