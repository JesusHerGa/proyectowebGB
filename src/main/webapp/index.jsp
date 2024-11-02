<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Principal</title>
<%
String url = "http://localhost:8081/proyectwebGB/";
%>
<style>
    /* Estilo simple para el menú */
    .menu {
        background-color: #f4f4f4;
        padding: 10px;
        border-radius: 5px;
        display: flex;
        justify-content: space-around;
        max-width: 400px;
        margin: 20px auto;
    }
    .menu a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        padding: 10px;
    }
    .menu a:hover {
        color: #007bff;
    }
</style>
</head>
<body>

<h1>Gestion de Biblioteca</h1>

<!-- Menú de navegación -->
<div class="menu">
    <a href="<%=url%>AutoresController">Gestión de Autores</a>
    <a href="<%=url %>EditorialesController">Gestión de Editoriales</a>
</div>

</body>
</html>

