package com.upiiz.practica2.repositories;

import com.upiiz.practica2.models.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    // Método personalizado para buscar un usuario por su correo
    @Query("SELECT * FROM usuarios WHERE email = :email")
    Usuario findByEmail(@Param("email") String email);
}