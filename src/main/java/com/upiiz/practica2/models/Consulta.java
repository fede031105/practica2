package com.upiiz.practica2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Table("consultas")
public class Consulta {

    @Id
    private Integer id_consulta;
    private Integer id_paciente;
    private LocalDate fecha;
    private String motivo;
    private String diagnostico;

    public Integer getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Integer id_consulta) {
        this.id_consulta = id_consulta;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}