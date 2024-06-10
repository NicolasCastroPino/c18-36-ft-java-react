package com.healthtech.demo.dto;

import com.healthtech.demo.enums.TipoEmocion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CrearEmocionDTO(
        @NotBlank
        String descripcion,
        @NotBlank
        @Size(min = 1, max = 30)
        String accion,
        @NotNull
        @NotEmpty
        List<TipoEmocion> tipoEmocion) {

}
