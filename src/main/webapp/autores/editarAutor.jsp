<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.unu.proyectwebGB.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nuevo autor</title>
</head>
<body>


	<%
	String url = "http://localhost:8080/proyectwebGB/";
	Autor autor;
	if(request.getAttribute("autor")== null)
		autor = new Autor();
	else{
		autor = (Autor)request.getAttribute("autor");
		System.out.println(autor.getIdAutor());
		System.out.println(autor.getNombre());
		System.out.println(autor.getNacionalidad());

	}
	
	%>
	<h3>Editar Autor</h3>

	<form role="form" action="<%=url%>AutoresController" method="POST">

		<input type="hidden" name="op" value="modificar">
		<input type="hidden" name="id" value="<%=autor.getIdAutor()%>"> <label
		
			form ="nombre">Nombre del autor</label> <input type="text"
			name="nombre" id="nombre" value="<%=autor.getNombre() %>"/> <br> 
			
			<label form ="nacionalidad" >Nacionalidad </label> 
			
			<input type="text"name="nacionalidad" id="nacionalidad" value="<%=autor.getNacionalidad()%>"> <br> 
			
			<input type="submit" value="Guardar" name="Guardar">
			
			 <a type="button" href="<%=url%>AutoresController?op=listar"> Volver</a>

	</form>



</body>
</html>