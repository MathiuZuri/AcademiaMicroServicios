package com.example.ms_kajita.service;

import com.example.ms_kajita.dto.UsuarioAsistenciaStatsDto;
import com.example.ms_kajita.entity.Asistencia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {


    List<Asistencia> listar();

    Asistencia guardar(Asistencia asistencia);

    Asistencia actualizar(Asistencia asistencia);

    Optional<Asistencia> listarPorId(Integer id);

    public void eliminarPorId(Integer id);


    List<Asistencia> listarPorNombreUsuario(String nombreUsuario);

    List<Asistencia> listarPorFecha(LocalDateTime desde, LocalDateTime hasta);

    List<Asistencia> listarPorNombreCurso(String nombreCurso);

    List<UsuarioAsistenciaStatsDto> usuariosConMasFaltas();

    List<UsuarioAsistenciaStatsDto> usuariosConMasTardanzas();

    List<UsuarioAsistenciaStatsDto> usuariosConMasPresentes();
}