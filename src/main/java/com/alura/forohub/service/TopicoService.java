package com.alura.forohub.service;

import com.alura.forohub.domain.Topico;
import com.alura.forohub.dto.DatosRegistroTopico;
import com.alura.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public List<Topico> listar() {
        return repository.findAll();
    }

    public Topico obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Topico registrar(DatosRegistroTopico datos) {
        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setFechaCreacion(LocalDateTime.now());
        return repository.save(topico);
    }

    public boolean existeTopico(String titulo, String mensaje) {
        return repository.existsByTituloAndMensaje(titulo, mensaje);
    }

    public Topico actualizar(Long id, DatosRegistroTopico datos) {

        Topico topico = obtenerPorId(id);

        if (topico == null) {
            return null;
        }

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());

        return repository.save(topico);
    }

    public boolean eliminar(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}