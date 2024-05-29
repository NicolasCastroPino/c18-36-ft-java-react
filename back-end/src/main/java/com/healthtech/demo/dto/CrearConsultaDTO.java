package com.healthtech.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CrearConsultaDTO(
        @NotNull @Valid
        PsicologoDTO psicologo,
        @NotNull @Valid
        PacienteDTO paciente) {
}
