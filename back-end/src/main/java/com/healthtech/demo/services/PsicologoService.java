package com.healthtech.demo.services;

import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.entities.Usuario;
import com.healthtech.demo.repositories.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PsicologoService implements IPsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Psicologo> getPsicologos() {
        List<Psicologo> listaPsicologos = this.psicologoRepository.findAll();
        return listaPsicologos;
    }

    public Psicologo savePsicologo(CrearPsicologoDTO psicologo) {
        boolean existe = this.psicologoRepository.existsByDocumento(psicologo.documento());
        if (existe) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El psicologo ya existe");
        } else {
            Usuario usuario = new Usuario(psicologo.usuario());
            usuario.setContrasenia(passwordEncoder.encode(psicologo.usuario().contrasenia()));
            Psicologo psicologoGuardado = new Psicologo(psicologo);
            psicologoGuardado.setUsuario(usuario);
            return psicologoRepository.save(psicologoGuardado);
        }
    }

    public void deletePsicologo(Long id) {
        this.psicologoRepository.deleteById(id);
    }
}
