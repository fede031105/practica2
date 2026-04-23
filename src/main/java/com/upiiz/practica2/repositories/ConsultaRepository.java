package com.upiiz.practica2.repositories;

import com.upiiz.practica2.models.Consulta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
}