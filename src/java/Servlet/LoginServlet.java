package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import Interfaces.IUsuario;
import Persistencia.EUsuario;
import Logica.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private IUsuario usuarioLogica;

    @Override
    public void init() throws ServletException {
        usuarioLogica = new Usuario();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        System.out.println("Nombre: " + nombreUsuario + " Clave: " + clave);
        // Llamar a la capa de lógica para validar el usuario
         Usuario usuarioValidado = usuarioLogica.validarUsuario(nombreUsuario, clave);
         System.out.println("AYUUUUDA: " + usuarioValidado.nombre);
        if (usuarioValidado != null) {
            // Login exitoso: guardar el objeto Entidad en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioValidado);
            response.sendRedirect(request.getContextPath() + "/Vistas/Menu.jsp");
            System.out.println("URL: " + request.getContextPath() + "/Vistas/Menu");
            
        } else {
            // Login fallido: mostrar la página de login con un mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            System.out.println("Intento de inicio de sesión fallido para: " + nombreUsuario);
            request.setAttribute("pageTitle", "Iniciar Sesión");
            request.setAttribute("pageContent", "Login.jsp");
            request.getRequestDispatcher("/Vistas/Login.jsp").forward(request, response);
        }
    }
}