package com.healthtech.demo.services;

import com.healthtech.demo.dto.ActualizarEmocionDTO;
import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.entities.Emocion;

import java.util.List;

public interface IEmocionService {

    //Metodo para listar todas las emociones
    public List<Emocion> getEmociones();

    //Metodo para dar de alta una emocion
    public Emocion saveEmocion(CrearEmocionDTO emocionDTO);

    //Metodo para dar de baja una emocion
    public void deleteEmocion (Long id);

    public Emocion modificarEmocion(ActualizarEmocionDTO emocionDTO);


}
