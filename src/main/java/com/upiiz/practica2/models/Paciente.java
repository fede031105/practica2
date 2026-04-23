package com.upiiz.practica2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Table("pacientes")
public class Paciente {

    @Id
    private Integer id_paciente;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private String genero;
    private String telefono;

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}