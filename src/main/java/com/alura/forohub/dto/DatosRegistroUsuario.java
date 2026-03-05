package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
       @NotBlank String correoElectronico,
       @NotBlank String contrasena
) {
}