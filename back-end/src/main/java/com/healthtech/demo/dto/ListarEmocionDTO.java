package com.healthtech.demo.dto;

import com.healthtech.demo.enums.TipoEmocion;

import java.time.LocalDate;
import java.util.List;

public record ListarEmocionDTO(
        Long id,
        LocalDate fechaCreacion,
        String descripcion,
        String accion,
        List<TipoEmocion> tipoEmocion
) {
}
