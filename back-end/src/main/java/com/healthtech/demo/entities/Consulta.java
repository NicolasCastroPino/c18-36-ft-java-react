package com.healthtech.demo.entities;

import com.healthtech.demo.enums.Especialidad;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo; // Relación uno a uno con Psicologo

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente; // Relación uno a uno con Paciente

    private LocalDateTime fecha;

    public Consulta(Psicologo psicologo, Paciente paciente, LocalDateTime fecha) {
        this.psicologo = psicologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }
}



