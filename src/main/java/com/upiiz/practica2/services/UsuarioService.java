package com.upiiz.practica2.services;

import com.upiiz.practica2.models.Usuario;
import com.upiiz.practica2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario registrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario autenticar(String email, String password) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}