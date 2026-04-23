package com.upiiz.practica2.repositories;

import com.upiiz.practica2.models.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}