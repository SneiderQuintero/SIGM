<%-- 
    Document   : Login
    Created on : 16/05/2025, 6:19:04 a. m.
    Author     : SneiderQuintero
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" type="text/css" href="../css/cssLogin.css">
</head>
<body>
<div class="login-container">
    <div class="logo-circle">
        <img src="../Recurso/logoUniversidad.png" alt="Logo Universidad de la Amazonia">
    </div>
    <h2>SISTEMA DE MAPEO DE RED DE LA<br>UNIVERSIDAD DE LA AMAZONIA</h2>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <div class="input-group">
            <div class="icon">
                <img src="../Recurso/logoUsuario.png" alt="Usuario" class="input-icon">
                <input type="text" name="usuario" placeholder="Usuario" required>
            </div>
        </div>
        <div class="input-group">
            <div class="icon">
                <img src="../Recurso/logoClave.png" alt="Contraseña" class="input-icon">
                <input type="password" name="clave" placeholder="Contraseña" required>
            </div>
        </div>
        <button type="submit" class="btn-ingresar">Ingresar</button>
    </form>
</div>
</body>
</html>
