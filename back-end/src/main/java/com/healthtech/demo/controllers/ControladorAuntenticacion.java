package com.healthtech.demo.controllers;

import com.healthtech.demo.dto.*;
import com.healthtech.demo.entities.Usuario;
import com.healthtech.demo.security.TokenService;
import com.healthtech.demo.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControladorAuntenticacion {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDTO.usuario(),
                usuarioDTO.contrasenia());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));
    }

    @Transactional
    @PostMapping("/sign-up")
    public ResponseEntity<CrearPacienteDTO> crearPaciente(@RequestBody @Valid CrearPacienteDTO paciente) {
        pacienteService.savePaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }
}
