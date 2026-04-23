package com.upiiz.practica2.controllers;

import com.upiiz.practica2.models.Paciente;
import com.upiiz.practica2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "pacientes/index";
    }

    @GetMapping("/crear")
    public String create(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/create";
    }

    @PostMapping("/guardar")
    public String save(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("paciente", pacienteService.findById(id));
        return "pacientes/create";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            pacienteService.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Paciente eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            // Este error ocurre cuando el paciente tiene una cita amarrada en la base de datos
            redirectAttributes.addFlashAttribute("error", "No puedes eliminar al paciente porque tiene una cita médica registrada.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ocurrió un error inesperado al intentar eliminar.");
        }
        return "redirect:/pacientes";
    }
}