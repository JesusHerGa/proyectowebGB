<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectwebGB.beans.Editorial" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListarEditores</title>


<%
String url = "http://localhost:8080/proyectwebGB/";
%>
<a type = "button" href = "<%=url%>EditorialesController?op=nuevo">  Nueva Editorial</a>




<table id="tabla" border="1">
	 <thead>
		 <tr>
			<th>Codigo del Editorial</th>
			<th>NOmbre</th>
			<th>Contacto</th>
			<th>Telefono</th>
			<th>Operaciones</th>
		 </tr>
	 </thead>
	 <tbody> 
		<%
		List<Editorial> listaAutores = (List<Editorial>) request.getAttribute("listaEditoriales");
        
        // Verificar si la lista no es nula
        if (listaEditoriales != null) {
            // Iterar sobre la lista de autores
            for (Editorial editorial : listaEditoriales) {
        %>
            <tr>
				 <td><%= editorial.getIdEditorial()%></td>
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