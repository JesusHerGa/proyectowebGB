<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectwebGB.beans.Editorial" %>
    
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
		location.href= "EditorialesController?op=eliminar&id="+id;
	}
	else{
		
	}
		
	
}
</script>

<title>ListarEditores</title>


<%
String url = "http://localhost:8081/proyectwebGB/";
%>
<div class="container">

<a type = "button" class= "btn btn-primary" href = "<%=url%>EditorialesController?op=nuevo">  Nueva Editorial</a>


<table class="table">
  <thead class="table-dark">
	 
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
		List<Editorial> listaEditores = (List<Editorial>) request.getAttribute("listaEditores");
        
        // Verificar si la lista no es nula
        if (listaEditores != null) {
            // Iterar sobre la lista de autores
            for (Editorial editorial : listaEditores) {
        %>
            <tr>
				 <td><%= editorial.getIdEditorial()%></td>
				 <td><%= editorial.getNombre() %></td>
				 <td><%= editorial.getContacto() %></td>
				 <td><%= editorial.getTelefono() %></td>
				 <td>
				 <a type = "button" class="btn btn-warning" href = "<%=url%>EditorialesController?op=obtener&id=<%=editorial.getIdEditorial()%>">modificar</a>
				 <a href="javascript:eliminar('<%=editorial.getIdEditorial()%>')" class="btn btn-danger"> Eliminar </a>
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
				 <td>No hay datos</td>
				 <td></td>
			 </tr>
        
        <%
            }
        %>
			
		
 	</tbody>
 	

 </table>
<a type = "button" class= "btn btn-secondary" href = "<%=url%>index.jsp">  Volver al Menu</a>
</head>
<body>

</body>
</html>