package com.healthtech.demo.dto;

import com.healthtech.demo.enums.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CrearConsultaDTO(
        @NotNull
        Especialidad especilidad,
//        @NotNull @Valid
//        PsicologoDTO psicologo,
//        @NotNull @Valid
//        PacienteDTO paciente,
        @NotNull
        Long idPsicologo,
        @NotNull
        Long idPaciente,
        @NotNull
        LocalDateTime fecha){
}
