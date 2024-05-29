package com.healthtech.demo.dto;

import com.healthtech.demo.enums.Especialidad;
import jakarta.validation.constraints.NotNull;

public record ActualizarPsicologoDTO(
        @NotNull
        Long id,
        String nombre,
        String apellido,
        String email,
        String telefono,
        Especialidad especialidad) {

}
