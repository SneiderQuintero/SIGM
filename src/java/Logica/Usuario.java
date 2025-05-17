/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Interfaces.IUsuario;
import Persistencia.EUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SneiderQuintero
 */
public class Usuario implements IUsuario{
    public int id;
    public String nombre;
    public String correo;
    public String clave;
    public List<Rol> roles;
    public boolean estado;
    
    public Usuario(){
        
    }
    public Usuario(String correo, String clave){
        this.id = -1;
        this.nombre = correo.split("@")[0];
        this.correo = correo;
        this.clave = clave;
        this.roles = new ArrayList<>();
        this.estado = true;
    }

    @Override
    public Usuario crearUsuario(String credencial, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario validarUsuario(String nombre, String clave) {
        try {
            EUsuario eusuario = new EUsuario();
            return eusuario.selectUsuario(nombre, clave);
        } catch (SQLException ex) {
            System.out.println("Error en la validacion de la consulta del usuario");
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Usuario> listar(){
        try {
            EUsuario eusuario = new EUsuario();
            return eusuario.selectAll();
        } catch (SQLException e) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, e + "ERROR EN LA CONSULTA SELECT ALL");
            return null;
        }
    }
    
}
