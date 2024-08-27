package com.TP3.demo;


import java.util.List;
import java.util.Set;

public interface IUsuarioService {

    void agregarUsuario(Usuario usuario);
    void modificarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
    List<Usuario> listarUsuarios();
    Usuario listarUnUsuario(Integer id);
}
