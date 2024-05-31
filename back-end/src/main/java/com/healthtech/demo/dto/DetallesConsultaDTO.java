package com.healthtech.demo.dto;

import com.healthtech.demo.entities.Consulta;
import com.healthtech.demo.entities.Paciente;
import com.healthtech.demo.entities.Psicologo;
import java.time.LocalDateTime;

public record DetallesConsultaDTO(Long id, Psicologo psicologo, Paciente paciente,  LocalDateTime fecha) {
    public DetallesConsultaDTO(Consulta consulta) {
        this(consulta.getId(),consulta.getPsicologo(),consulta.getPaciente(),consulta.getFecha());
    }
}
