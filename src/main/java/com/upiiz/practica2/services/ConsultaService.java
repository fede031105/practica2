package com.upiiz.practica2.services;

import com.upiiz.practica2.models.Consulta;
import com.upiiz.practica2.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public Iterable<Consulta> findAll() {
        return repository.findAll();
    }

    public Consulta findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Consulta save(Consulta consulta) {
        return repository.save(consulta);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public long count() {
        return repository.count();
    }
}