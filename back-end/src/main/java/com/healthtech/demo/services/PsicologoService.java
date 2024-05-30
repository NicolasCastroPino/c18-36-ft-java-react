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


    public List<Psicologo> getPsicologos() {
        List<Psicologo> listaPsicologos = this.psicologoRepository.findAll();
        return listaPsicologos;
    }

    public Psicologo savePsicologo(CrearPsicologoDTO psicologo) {
        boolean existe = this.psicologoRepository.existsByDocumento(psicologo.documento());
        if (existe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El psicologo ya existe");
        } else {
            Psicologo psicologoGuardado = (Psicologo)this.psicologoRepository.save(new Psicologo(psicologo));
            return psicologoGuardado;
        }
    }

    public void deletePsicologo(Long id) {
        this.psicologoRepository.deleteById(id);
    }
}
