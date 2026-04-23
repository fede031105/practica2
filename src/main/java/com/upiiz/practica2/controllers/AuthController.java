package com.upiiz.practica2.controllers;

import com.upiiz.practica2.models.Usuario;
import com.upiiz.practica2.services.UsuarioService;
import com.upiiz.practica2.services.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    // Redirección inteligente de la raíz (/)
    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") != null) {
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Usuario usuario = usuarioService.autenticar(email, password);
        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario.getNombre_completo());
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Correo o contraseña incorrectos.");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute Usuario usuario) {
        usuarioService.registrar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, Model model) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario != null) {
            try {
                emailService.enviarContrasena(usuario.getEmail(), usuario.getPassword());
                model.addAttribute("mensaje", "Te hemos enviado un correo con tu contraseña.");
            } catch (Exception e) {
                model.addAttribute("error", "Error al enviar el correo. Revisa la configuración.");
            }
        } else {
            model.addAttribute("error", "El correo no está registrado en nuestro sistema.");
        }
        return "forgot-password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}