package com.alura.forohub.controller;

import com.alura.forohub.domain.Usuario;
import com.alura.forohub.dto.DatosAutenticacionUsuario;
import com.alura.forohub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> autenticar(@RequestBody DatosAutenticacionUsuario datos) {

        var authToken = new UsernamePasswordAuthenticationToken(
                datos.correoElectronico(),
                datos.contrasena()
        );

        var authentication = authenticationManager.authenticate(authToken);

        var usuario = (Usuario) authentication.getPrincipal();

        var token = tokenService.generarToken(usuario);

        return ResponseEntity.ok(token);
    }
}