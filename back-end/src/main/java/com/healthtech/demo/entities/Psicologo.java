package com.healthtech.demo.entities;

import com.healthtech.demo.enums.Especialidad;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String documento;

    private boolean activo;

    private double valoracion;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    //Se agtego usuario al Medico
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "psicologo_paciente", joinColumns = @JoinColumn(name = "id_psicologo"), inverseJoinColumns = @JoinColumn(name = "id_paciente"))
    private List<Paciente> pacientes;

    @OneToOne(mappedBy = "psicologo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Consulta consulta; // Relación uno a uno con Consulta
}
