package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;

import java.util.List;

public interface IPsicologoService {
    List<Psicologo> getPsicologos();

    Psicologo savePsicologo(CrearPsicologoDTO psicologo);

    void deletePsicologo(Long id);
}
