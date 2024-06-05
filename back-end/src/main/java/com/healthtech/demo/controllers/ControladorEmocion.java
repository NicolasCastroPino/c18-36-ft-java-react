package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.CrearEmocionDTO;
import com.healthtech.demo.dto.ListarEmocionDTO;
import com.healthtech.demo.entities.Emocion;
import com.healthtech.demo.services.EmocionService;
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
@RequestMapping("/emocion")
public class ControladorEmocion {
    @Autowired
    private EmocionService emocionService;

    @GetMapping("/listaremociones")
    public ResponseEntity<List<ListarEmocionDTO>> listarEmociones() {
        List<Emocion> emocionList = emocionService.getEmociones();
        ModelMapper modelMapper = new ModelMapper();

        List<ListarEmocionDTO> emocionDTOS = emocionList.stream()
                .map(emocion -> modelMapper.map(emocion, ListarEmocionDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(emocionDTOS);
    }

    @Transactional
    @PostMapping({"/crear"})
    public ResponseEntity<CrearEmocionDTO> crearEmocion(@RequestBody @Valid CrearEmocionDTO emocion) {
        emocionService.saveEmocion(emocion);
        return ResponseEntity.status(HttpStatus.CREATED).body(emocion);
    }


}