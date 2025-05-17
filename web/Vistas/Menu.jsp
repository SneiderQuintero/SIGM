<%-- 
    Document   : Menu
    Created on : 16/05/2025, 10:36:32 a. m.
    Author     : SneiderQuintero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Panel de Gestión - Universidad de la Amazonia</title>
    <link rel="stylesheet" type="text/css" href="../css/cssMenu.css">
</head>
<body>

  <div class="sidebar" id="sidebar">
    
    <a href="#">Panel de navegación</a>
    <a href="../Vistas/gestionUsuario.jsp"><img src="../Recurso/agregar-contacto.png" alt="Gestionar usuarios" class="menu-icon"> Gestionar Usuarios</a>
    <a href="#"><img src="../Recurso/solucion-de-problemas.png" alt="Gestionar dispositivos" class="menu-icon"> Gestionar Dispositivos</a>
    <a href="#"><img src="../Recurso/puerta.png" alt="Gestionar salas" class="menu-icon"> Gestionar Salas</a>
    <a href="#"><img src="../Recurso/servidor.png" alt="Gestionar cuarto de comunicacion" class="menu-icon"> Gestionar Cuarto Comunicación</a>
    <a href="#"><img src="../Recurso/inventario.png" alt="Usuario" class="menu-icon"> Gestionar Inventario</a>
    <a href="#"><img src="../Recurso/reporte.png" alt="Usuario" class="menu-icon"> Gestionar Reporte</a>
    <a href="#"><img src="../Recurso/auditoria.png" alt="Usuario" class="menu-icon"> Gestionar Auditoria</a>
  </div>

  <div class="main" id="main">
    <div class="navbar">
      <span class="toggle-btn" onclick="toggleSidebar()">☰</span>
      <img src="../Recurso/logoUniversidad.png" alt="Logo Universidad de la Amazonia">
      <div class="user-area">
        <div class="user">
          <span>Usuario</span>
          <img src="../Recurso/logoUsuario.png" alt="Usuario" class="input-icon">
        </div>
        <div class="cerrar">
          <a href="../Vistas/Login.jsp">cerrar sesión</a>
        </div>
      </div>
    </div>

    <div class="content">
      <div class="section">
        <h3>INFORMACIÓN DE SALAS</h3>
        <div class="rooms">
          <div class="room-card">
            <h4>SALA 1</h4>
            <p>CAPACIDAD: 35</p>
            <p>EQUIPOS: 35</p>
            <p>TELEVISOR: Samsung TV X</p>
            <p>ANTENA: NO</p>
          </div>
          <div class="room-card">
            <h4>SALA 2</h4>
            <p>CAPACIDAD: 30</p>
            <p>EQUIPOS: 28</p>
            <p>TELEVISOR: PHILIPS</p>
            <p>ANTENA: NO</p>
          </div>
          <div class="room-card">
            <h4>SALA 3</h4>
            <p>CAPACIDAD: 30</p>
            <p>EQUIPOS: 28</p>
            <p>TELEVISOR: Samsung TV X</p>
            <p>ANTENA: SÍ</p>
          </div>
          <div class="room-card">
            <h4>SALA 4</h4>
            <p>CAPACIDAD: 30</p>
            <p>EQUIPOS: 30</p>
            <p>TELEVISOR: Samsung</p>
            <p>ANTENA: NO</p>
          </div>
        </div>
      </div>

      <div class="section">
        <h3>INFORMACIÓN DE CUARTO DE COMUNICACIÓN</h3>
        <div class="network">
          <div class="net-card">
            <p>GABINETES: 2</p>
          </div>
          <div class="net-card">
            <p>SWITCH: 10</p>
          </div>
          <div class="net-card">
            <p>PUNTOS DE RED: 350</p>
          </div>
          <div class="net-card">
            <p>PUNTOS EN USO: 235</p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    function toggleSidebar() {
      const sidebar = document.getElementById('sidebar');
      const main = document.getElementById('main');
      sidebar.classList.toggle('closed');
      main.classList.toggle('full');
    }
  </script>

</body>
</html>
