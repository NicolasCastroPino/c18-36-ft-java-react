package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.CrearConsultaDTO;
import com.healthtech.demo.dto.DetallesConsultaDTO;
import com.healthtech.demo.dto.PacienteDTO;
import com.healthtech.demo.dto.PsicologoDTO;
import com.healthtech.demo.manejoErrores.ValidacionDeIntegridad;
import com.healthtech.demo.services.ConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key") //Necesario para Swagger UI con Bearer Tokens
public class ControladorConsulta {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/crear")
    public ResponseEntity<DetallesConsultaDTO> agendarConsulta(@RequestBody @Valid CrearConsultaDTO datos) throws ValidacionDeIntegridad {
        var consulta = consultaService.Agendar(datos);
        return ResponseEntity.ok(new DetallesConsultaDTO(
                consulta.getId(),
                new PsicologoDTO(consulta.getPsicologo().getNombre(), consulta.getPsicologo().getApellido(), consulta.getPsicologo().getDocumento()),
                new PacienteDTO(consulta.getPaciente().getNombre(), consulta.getPaciente().getApellido(), consulta.getPaciente().getDocumento()),
                consulta.getFecha()));
    }

    @GetMapping("/listarConsultas")
    public ResponseEntity<List<DetallesConsultaDTO>> listarConsultas() {
        var consultas = consultaService.getConsultas();
        List<DetallesConsultaDTO> listarConsultas = consultas.stream()
                .map(consulta -> new DetallesConsultaDTO(
                consulta.getId(),
                new PsicologoDTO(consulta.getPsicologo().getNombre(), consulta.getPsicologo().getApellido(), consulta.getPsicologo().getDocumento()),
                new PacienteDTO(consulta.getPaciente().getNombre(), consulta.getPaciente().getApellido(), consulta.getPaciente().getDocumento()),
                consulta.getFecha())).collect(Collectors.toList());
        return ResponseEntity.ok(listarConsultas);
    }
}
