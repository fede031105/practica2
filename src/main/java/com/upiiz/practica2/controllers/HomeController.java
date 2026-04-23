package com.upiiz.practica2.controllers;

import com.upiiz.practica2.services.ConsultaService;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("usuarioLogueado", "Federico");
        model.addAttribute("totalPacientes", pacienteService.count());
        model.addAttribute("totalConsultas", consultaService.count());
        model.addAttribute("consultasHoy", 0);

        // ¡Esta es la línea clave que cambiamos!
        return "dashboard";
    }
}