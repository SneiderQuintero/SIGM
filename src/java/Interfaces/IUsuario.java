/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Logica.Usuario;
import java.util.ArrayList;

/**
 *
 * @author SneiderQuintero
 */
public interface IUsuario {
    public Usuario crearUsuario(String credencial, String clave);
    public boolean actualizarUsuario(Usuario usuario);
    public boolean eliminarUsuario(Usuario usuario);
    public Usuario buscarUsuario(Usuario usuario);
    public Usuario validarUsuario(String nombre, String clave);
    public ArrayList<Usuario> listar();
    
}
