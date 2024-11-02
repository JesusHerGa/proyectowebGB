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

<title>Editar Editorial</title>
</head>
<body>


	<%
	String url = "http://localhost:8081/proyectwebGB/";
	Editorial editorial;
	if(request.getAttribute("editorial")== null)
		editorial = new Editorial();
	else{
		editorial = (Editorial)request.getAttribute("editorial");
		System.out.println(editorial.getIdEditorial());
		System.out.println(editorial.getNombre());
		System.out.println(editorial.getContacto());
		System.out.println(editorial.getTelefono());
		

	}
	
	%>
	
	<div class= "container">
	<h3>Editar Editorial</h3>

	<form role="form" action="<%=url%>EditorialesController" method="POST">

		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="id" value="<%=editorial.getIdEditorial()%>">
		 <label	form ="nombre">Nombre de la Editorial</label> 
			<input type="text"	name="nombre" id="nombre" value="<%=editorial.getNombre() %>"/> <br> 
			
			<label form ="contacto" >Contacto </label> 
			<input type="text"name="contacto" id="contacto" value="<%=editorial.getContacto()%>"> <br> 
			
			<label form ="telefono" >Telefono  </label> 
			<input type="text"name="telefono" id="telefono" value="<%=editorial.getTelefono() %>"> <br> 
			
			<input type="submit" class="btn btn-primary" value="Guardar" name="Guardar">
			
			 <a type="button" class="btn btn-secondary" href="<%=url%>EditorialesController?op=listar"> Volver</a>

	</form>
</div>

</body>
</html>