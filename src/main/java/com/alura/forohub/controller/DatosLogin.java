package com.alura.forohub.controller;

import jakarta.validation.constraints.NotBlank;

public record DatosLogin(
      @NotBlank String email,
      @NotBlank String password
) {}