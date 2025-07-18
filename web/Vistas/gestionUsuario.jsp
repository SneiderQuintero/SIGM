<%@page import="Logica.Usuario"%>
                                                                                                                                                                                                                                                                                                                                                                                                         <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Gestión de Usuarios</title>
</head>
<body>
    <h2>Gestión de Usuarios</h2>
    <form action="${pageContext.request.contextPath}/GestionUsuarioServlet" method="post">
        Usuario: <input type="text" name="nombre"><br>
        Clave: <input type="password" name="clave"><br>
        Rol: <input type="text" name="rol"><br>
        Estado: 
        <select name="estado">
            <option value="Activo">Activo</option>
            <option value="Desactivado">Desactivado</option>
        </select><br>
        <button name="accion" value="crear">Crear</button>
        <button name="accion" value="actualizar">Actualizar</button>
        <button name="accion" value="eliminar">Eliminar</button>
    </form>

    <table border="1">
        <tr>
            <th>#</th><th>Usuario</th><th>Rol</th><th>Estado</th>
        </tr>
        <%
            List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
            int i = 1;
            for (Usuario u : lista) {
        %>
            <tr>
                <td><%= i++ %></td>
                <td><%= u.nombre %></td>
                <td><%= u.roles %></td>
                <td><%= u.estado %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
