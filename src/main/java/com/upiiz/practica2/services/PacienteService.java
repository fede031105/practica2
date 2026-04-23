package com.upiiz.practica2.services;

import com.upiiz.practica2.models.Paciente;
import com.upiiz.practica2.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Iterable<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public long count() {
        return repository.count();
    }
}