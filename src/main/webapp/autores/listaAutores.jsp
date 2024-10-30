<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectwebGB.beans.Autor" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.css.js">
</script>

<script >
function eliminar(id) {
	if(confirm("Desea Eliminar el registro")== true){
		location.href= "AutoresController?op=eliminar&id="+id;
	}
	else{
		
	}
		
	
}
</script>

<title>ListarAutores</title>


<%
String url = "http://localhost:8080/proyectwebGB/";
%>

<div class="container">

<a type = "button" class="btn btn-primary" href = "<%=url%>AutoresController?op=nuevo">  Nuevo Autor</a>

<table class="table">
  <thead class="table-dark">
	 
		 <tr>
			<th>Codigo del autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad</th>
			<th>Operaciones</th>
		 </tr>
	 </thead>
	 <tbody> 
		<%
		List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");
        
        // Verificar si la lista no es nula
        if (listaAutores != null) {
            // Iterar sobre la lista de autores
            for (Autor autor : listaAutores) {
        %>
            <tr>
				 <td><%= autor.getIdAutor()%></td>
				 <td><%= autor.getNombre()%></td>
				 <td><%= autor.getNacionalidad() %></td>
				 <td>
				 <a type ="button" class="btn btn-success" href = "<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">modificar</a>
				 <!--<a type="button" class="btn btn-danger" href = "<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">eliminar</a> 
				 -->
				 <a href="javascript:eliminar('<%=autor.getIdAutor()%>')" class="btn btn-danger">Eliminar</a>
				 </td>
			 </tr>
        <%
            }
        } else {
        %>
        
         	 <tr>
				 <td>No hay datos</td>
				 <td>No hay datos</td>
				 <td>No hay datos</td>
				 <td></td>
			 </tr>
        
        <%
            }
        %>
			
		
 	</tbody>
 	

 </table>
<a type = "button" class="btn btn-secondary" href = "<%=url%>AutoresController">  Actualizar</a>
</div>




</head>
<body>

</body>
</html>