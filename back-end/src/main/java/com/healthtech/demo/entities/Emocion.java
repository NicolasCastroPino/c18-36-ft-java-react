package com.healthtech.demo.entities;

import com.healthtech.demo.dto.ActualizarEmocionDTO;
import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.enums.TipoEmocion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaCreacion;

    @Enumerated(EnumType.STRING)
    //@ElementCollection(targetClass = TipoEmocion.class) Usar esto si es una coleccion
    private TipoEmocion tipoEmocion;

    private String descripcion;
    private String accion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    public Emocion(CrearEmocionDTO emocionDTO) {
        this.accion = emocionDTO.accion();
        this.descripcion = emocionDTO.descripcion();
        this.fechaCreacion = LocalDate.now();
        this.tipoEmocion = emocionDTO.tipoEmocion();
    }

    public void ActualizarEmocion(ActualizarEmocionDTO emocionActualizada) {
        if (emocionActualizada.descripcion() != null) {
            this.descripcion = emocionActualizada.descripcion();
        }
        if (emocionActualizada.accion() != null) {
            this.accion = emocionActualizada.accion();
        }
        if (emocionActualizada.tipoEmocion() != null) {
            this.tipoEmocion = emocionActualizada.tipoEmocion();
        }
    }

}
