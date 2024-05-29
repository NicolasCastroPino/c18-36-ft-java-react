package com.healthtech.demo.entities;

import com.healthtech.demo.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String usuario;
    
    private String contrasenia;

    Usuario(UsuarioDTO usuarioDTO) {
        this.usuario = usuarioDTO.usuario();
        this.usuario = usuarioDTO.contrasenia();
    }
}
