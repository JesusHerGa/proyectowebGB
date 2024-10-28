<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectwebGB.beans.Autor" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListarAutores</title>


<%
String url = "http://localhost:8080/proyectwebGB/";
%>
<a type = "button" href = "<%=url%>AutoresController?op=nuevo">  Nuevo Autor</a>




<table id="tabla" border="1">
	 <thead>
		 <tr>
			<th>Codigo del autor</th>
			<th>Nacionalidad</th>
			<th>Nombre del autor</th>
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
				 <a type = "button" href = "<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">modificar</a>
				 <a type = "button" href = "<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">eliminar</a>
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
<a type = "button" href = "<%=url%>AutoresController">  Volver</a>
</head>
<body>

</body>
</html>