package com.TP3.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario, @RequestHeader("Autorizador") String token) {
        System.out.println("Token enviado: " + token);

        if(token.equals("1234")) {
            usuarioService.agregarUsuario(usuario);
            return ResponseEntity.ok(HttpStatus.OK);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    public Usuario getUsuario(@RequestParam Integer id, @RequestHeader("Autorizador") String token){
        System.out.println("Token enviado: " + token);

        if(token.equals("1234")) {
            return usuarioService.listarUnUsuario(id);
        }else{
            return null;
        }
    }

    @PutMapping
    public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario, @RequestHeader("Autorizador") String token){
        System.out.println("Token enviado: " + token);
        if(token.equals("1234")) {
            usuarioService.modificarUsuario(usuario);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping
    public ResponseEntity<?> eliminarUsuario(@RequestParam Integer id, @RequestHeader("Autorizador") String token){
        System.out.println("Token enviado: " + token);

        if(token.equals("1234")) {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.badRequest().build();
        }


    }

    @GetMapping("/Usuarios")
    public Collection<Usuario> getTodosUsuarios(@RequestHeader("Autorizador") String token){
        System.out.println("Token enviado: " + token);
        if(token.equals("1234")) {
            return usuarioService.listarUsuarios();
        }
        else {
            return null;
        }
    }

}
