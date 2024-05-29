package com.healthtech.demo.entities;

import com.healthtech.demo.dto.ActualizarPacienteDTO;
import com.healthtech.demo.dto.CrearPacienteDTO;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String documento;

    private boolean activo;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Consulta consulta; // Relación uno a uno con Consulta

    @ManyToMany(mappedBy = "pacientes", fetch = FetchType.LAZY)
    private List<Psicologo> psicologos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Paciente(CrearPacienteDTO paciente) {
        this.nombre = paciente.nombre();
        this.apellido = paciente.apellido();
        this.email = paciente.email();
        this.telefono = paciente.telefono();
        this.documento = paciente.documento();
        this.activo = true;
        this.usuario = new Usuario(paciente.usuario());
    }

    public void ActualizarEntidadPaciente(ActualizarPacienteDTO pacienteActualizado) {
        if (pacienteActualizado.nombre() != null) {
            this.nombre = pacienteActualizado.nombre();
        }
        if (pacienteActualizado.apellido() != null) {
            this.apellido = pacienteActualizado.apellido();
        }
        if (pacienteActualizado.email() != null) {
            this.email = pacienteActualizado.email();
        }
        if (pacienteActualizado.telefono() != null) {
            this.telefono = pacienteActualizado.telefono();
        }
    }
}
