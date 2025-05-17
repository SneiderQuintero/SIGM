/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.util.List;
import Logica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SneiderQuintero
 */
public class EUsuario {
    ConexionBD conexion;
    int id;
    String nombre;
    String correo;
    String clave;
    List<Rol> roles;
    boolean estado;

    public EUsuario(){
        this.conexion = new ConexionBD();
    }
    
    public EUsuario(int id, String nombre, String correo, String clave, List<Rol> roles, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.roles = roles;
        this.estado = estado;
    }
    
    public Usuario selectUsuario(String nombreUsuario, String clave) throws SQLException {
        Usuario usuario = null;
        // Consulta SQL para seleccionar al usuario por nombre de usuario.
        // ¡Importante!: No selecciones la contraseña directamente para mayor seguridad.
        String sql = "SELECT * " // Corregido el nombre de la columna a fk_id_rol
                     + "FROM Usuario u "
                     + "WHERE u.nombre = ?";
        Connection conn = conexion.getConnection();
        System.out.println("Conexion:" + conn);
        PreparedStatement stmt = conn.prepareStatement(sql);
         // Crea una sentencia preparada para la consulta SQL
            stmt.setString(1, nombreUsuario); // Establece el parámetro para el nombre de usuario.
            try (ResultSet rs = stmt.executeQuery()) { // Ejecuta la consulta y obtiene el resultado
                if (rs.next()) {
                    // El usuario existe, ahora verificamos la contraseña.
                    // ¡Nunca compares contraseñas directamente en la base de datos!
                    String claveAlmacenada = rs.getString("clave"); // Obtiene la contraseña de la base de datos

                    if (clave.equals(claveAlmacenada)) {
                        // La contraseña es correcta, mapeamos el usuario.
                        usuario = mapearUsuario(rs);
                    } else {
                        // La contraseña es incorrecta, registra el error y retorna null.
                        System.out.println("Contraseña incorrecta");
                        return null;
                    }
                } else {
                    // No se encontró el usuario, registra el error y retorna null.
                    System.out.println("Usuario no encontrado");
                    return null;
                }
            }
        
        return usuario;
    }
    
     public ArrayList<Usuario> selectAll() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario u ";
        Connection conn = conexion.getConnection();
        System.out.println("Conexion:" + conn);
        PreparedStatement stmt = conn.prepareStatement(sql);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                    Usuario usuario = mapearUsuario(rs);
                    lista.add(usuario);
            } 
        }
         System.out.println("LISTA");
         for(Usuario i : lista){
             System.out.println("I : " + i.nombre);
         }
        return lista;
    }
    
    
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.id = rs.getInt("id");
        usuario.nombre = rs.getString("nombre");
        usuario.correo = rs.getString("correo");
        System.out.println("USUARIO MAPEADO");
        return usuario;
    }
    
}
