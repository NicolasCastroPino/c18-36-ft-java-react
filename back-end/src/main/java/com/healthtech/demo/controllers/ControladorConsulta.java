package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.services.ConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key") //Necesario para Swagger UI con Bearer Tokens
public class ControladorConsulta {
    
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity agendarConsulta(@RequestBody @Valid CrearConsultaDTO datos) throws ValidacionDeIntegridad {
        var response = consultaService.Agendar(datos);
        return ResponseEntity.ok(response);    
    }
}
