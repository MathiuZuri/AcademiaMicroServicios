package com.example.ms_kajita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAsistenciaStatsDto {
    private Long usuarioId;
    private String usuarioNombre;
    private long faltas;
    private long tardanzas;
    private long presentes;
    // + getters/setters, constructor, etc.
}
