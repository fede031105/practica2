package com.upiiz.practica2.controllers;

import com.upiiz.practica2.services.ConsultaService;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstadisticaController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/estadisticas")
    public String index(Model model) {
        model.addAttribute("usuarioLogueado", "Federico");

        long totalPacientes = pacienteService.count();
        long totalConsultas = consultaService.count();

        model.addAttribute("totalPacientes", totalPacientes);
        model.addAttribute("totalConsultas", totalConsultas);

        return "estadisticas";
    }
}