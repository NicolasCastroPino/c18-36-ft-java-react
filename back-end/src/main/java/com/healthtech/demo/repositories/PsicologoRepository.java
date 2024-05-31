package com.healthtech.demo.repositories;

import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.enums.Especialidad;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {

//    @Query("""
//            select m from Medico m
//            where m.activo= 1 
//            and
//            m.especialidad=:especialidad 
//            and
//            m.id not in(  
//                select c.medico.id from Consulta c
//                where
//                c.fecha=:fecha
//            )
//            order by rand()
//            limit 1
//            """)
//    Psicologo seleccionarPsciologoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);

//    @Query("""
//            select m.activo 
//            from Medico m
//            where m.id=:idMedico
//            """)
    Boolean findActivoById(Long idMedico);
}
