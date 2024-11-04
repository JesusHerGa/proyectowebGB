<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.unu.proyectwebGB.beans.Genero" %>
    
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
		location.href= "GenerosController?op=eliminar&id="+id;
	}
	else{
		
	}
		
	
}
</script>

<title>ListarGeneros</title>


<%
String url = "http://localhost:8081/proyectwebGB/";
%>

<div class="container">

<a type = "button" class="btn btn-primary" href = "<%=url%>GenerosController?op=nuevo">  Nuevo Genero</a>

<table class="table">
  <thead class="table-dark">
	 
		 <tr>
			<th>Codigo del Genero</th>
			<th>Nombre del Genero</th>
			<th>Descripcion-</th>
			<th>Operaciones</th>
		 </tr>
	 </thead>
	 <tbody> 
		<%
		List<Genero> listaGeneros = (List<Genero>) request.getAttribute("listaGeneros");
        
        // Verificar si la lista no es nula
        if (listaGeneros != null) {
            // Iterar sobre la lista de autores
            for (Genero genero : listaGeneros) {
        %>
            <tr>
				 <td><%= genero.getIdGenero()%></td>
				 <td><%= genero.getNombre()%></td>
				 <td><%= genero.getDescripcion() %></td>
				 <td>
				 <a type ="button" class="btn btn-success" href = "<%=url%>GenerosController?op=obtener&id=<%=genero.getIdGenero()%>">modificar</a>
				 <!--<a type="button" class="btn btn-danger" href = "<%=url%>GenerosController?op=eliminar&id=<%=genero.getIdGenero()%>">eliminar</a> 
				 -->
				 <a href="javascript:eliminar('<%=genero.getIdGenero()%>')" class="btn btn-danger">Eliminar</a>
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
<a type = "button" class="btn btn-secondary" href = "<%=url%>index.jsp">  Volver al Menu </a>
</div>




</head>
<body>

</body>
</html>