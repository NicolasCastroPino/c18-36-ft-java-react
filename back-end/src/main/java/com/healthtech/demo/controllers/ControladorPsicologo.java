package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.CrearPsicologoDTO;
import com.healthtech.demo.dto.ListarPsicologoDTO;
import com.healthtech.demo.entities.Psicologo;
import com.healthtech.demo.services.PsicologoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/psicologo")
public class ControladorPsicologo {

    @Autowired
    private PsicologoService psicologoService;

    @Transactional
    @PostMapping("/crear")
    public ResponseEntity<CrearPsicologoDTO> crearPsicologo(@RequestBody @Valid CrearPsicologoDTO psicologo) {
        psicologoService.savePsicologo(psicologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(psicologo);
    }

    @Transactional
    @PostMapping("/eliminar/{id}")
    public ResponseEntity eliminarPsicologo(@PathVariable Long id) {
        psicologoService.deletePsicologo(id);
        return ResponseEntity.ok("El objeto fue eliminado correctamente");
    }

    @GetMapping("/listarpsicologos")
    public ResponseEntity<List<ListarPsicologoDTO>> listarPsicologos() {
        List<Psicologo> psicologos = psicologoService.getPsicologos();
        ModelMapper modelMapper = new ModelMapper();
        List<ListarPsicologoDTO> psicologosDTOs = psicologos.stream()
                .map(psicologo -> modelMapper.map(psicologo, ListarPsicologoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(psicologosDTOs);
    }
}
