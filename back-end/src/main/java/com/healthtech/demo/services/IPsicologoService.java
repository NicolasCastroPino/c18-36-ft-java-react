package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;

import java.util.List;

public interface IPsicologoService {

    //metodo para traer todos los psicologos
    public List<Psicologo> getPsicologos();

    //metodo para dar de alta un psicologo
    public Psicologo savePsicologo(CrearPsicologoDTO psicologo);


    //metodo para dar de baja un psicologo
    public void deletePsicologo(Long id);
}
