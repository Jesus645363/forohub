package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank String correoElectronico,
        @NotBlank String contrasena
) {
}