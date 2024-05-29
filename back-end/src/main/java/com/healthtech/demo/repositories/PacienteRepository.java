package com.healthtech.demo.repositories;

import com.healthtech.demo.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    //Nuevo Codigo de Cristian
    boolean existsByNombreAndApellido(String titulo, String mensaje);
}
