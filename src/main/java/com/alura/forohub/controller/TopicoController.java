package com.alura.forohub.controller;

import com.alura.forohub.domain.Topico;
import com.alura.forohub.dto.DatosRegistroTopico;
import com.alura.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;


    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Topico topico = service.obtenerPorId(id);

        if (topico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(topico);
    }


    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody @Valid DatosRegistroTopico datos) {

        if (service.existeTopico(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().body("Tópico ya existente");
        }

        Topico topico = service.registrar(datos);
        return ResponseEntity.ok(topico);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,
                                        @RequestBody @Valid DatosRegistroTopico datos) {

        Topico topicoActualizado = service.actualizar(id, datos);

        if (topicoActualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(topicoActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        boolean eliminado = service.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}