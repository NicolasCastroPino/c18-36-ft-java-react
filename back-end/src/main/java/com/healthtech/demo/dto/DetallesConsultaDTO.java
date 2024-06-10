package com.healthtech.demo.dto;

import java.time.LocalDateTime;

public record DetallesConsultaDTO(Long id, PsicologoDTO psicologo, PacienteDTO paciente,  LocalDateTime fecha, String linkVideollamada) {
}

