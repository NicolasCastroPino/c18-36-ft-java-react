package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.repositories.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PsicologoService implements IPsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Override
    public List<Psicologo> getPsicologos() {
        List<Psicologo> listaPsicologos = psicologoRepository.findAll();
        return listaPsicologos;
    }

    @Override
    public Psicologo savePsicologo(CrearPsicologoDTO psicologo) {
        var existe = psicologoRepository.exitsByDocumento(psicologo.documento());
        if (existe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El psicologo ya existe");
        }
        Psicologo psicologoGuardado = psicologoRepository.save(new Psicologo(psicologo));
        return psicologoGuardado;
    }


    @Override
    public void deletePsicologo(Long id) {
        psicologoRepository.deleteById(id);
    }
}
