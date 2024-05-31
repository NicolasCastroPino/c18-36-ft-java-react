package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.dto.DetallesConsultaDTO;
import com.healthtech.demo.entities.Psicologo;
import org.springframework.http.ResponseEntity;

public interface IConsultaService {
    public ResponseEntity<DetallesConsultaDTO> Agendar(CrearConsultaDTO datos);
    
//    public Psicologo seleccionarPsicologo(CrearConsultaDTO datos);
}
