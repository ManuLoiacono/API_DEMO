package com.TP3.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    public IUsuarioRepository usuarioRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public Usuario listarUnUsuario(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario us = null;
        if(usuario.isPresent()){
            us = mapper.convertValue(usuario, Usuario.class);
        }

        return us;
    }
}
