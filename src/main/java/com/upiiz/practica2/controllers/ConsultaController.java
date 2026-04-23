package com.upiiz.practica2.controllers;

import com.upiiz.practica2.models.Consulta;
import com.upiiz.practica2.services.ConsultaService;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Inyectamos también el de pacientes para poder llenar el menú desplegable
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("consultas", consultaService.findAll());
        model.addAttribute("usuarioLogueado", "Federico");
        return "consultas/index";
    }

    @GetMapping("/crear")
    public String create(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("usuarioLogueado", "Federico");
        return "consultas/create";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Consulta consulta) {
        consultaService.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("consulta", consultaService.findById(id));
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("usuarioLogueado", "Federico");
        return "consultas/create";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Integer id) {
        consultaService.deleteById(id);
        return "redirect:/consultas";
    }
}