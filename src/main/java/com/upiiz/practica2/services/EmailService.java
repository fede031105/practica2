package com.upiiz.practica2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarContrasena(String destino, String contrasena) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destino);
        message.setSubject("Recuperación de Contraseña - Gestión Clínica");
        message.setText("Hola,\n\nHas solicitado recuperar tu contraseña.\n\nTu contraseña es: " + contrasena + "\n\nYa puedes iniciar sesión.");

        mailSender.send(message);
    }
}