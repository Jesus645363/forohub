package com.alura.forohub.controller;

import com.alura.forohub.domain.Usuario;
import com.alura.forohub.dto.DatosRegistroUsuario;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody DatosRegistroUsuario datos) {

        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByCorreoElectronico(datos.correoElectronico());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        Usuario usuario = new Usuario();
        usuario.setCorreoElectronico(datos.correoElectronico());
        usuario.setContrasena(passwordEncoder.encode(datos.contrasena()));

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}