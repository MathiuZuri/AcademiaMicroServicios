package com.example.ms_kajita.service;

<<<<<<< HEAD
import com.example.ms_kajita.dto.UsuarioAsistenciaStatsDto;
import com.example.ms_kajita.entity.Asistencia;

import java.time.LocalDateTime;
=======
import com.example.ms_kajita.entity.Asistencia;

>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {


    List<Asistencia> listar();

    Asistencia guardar(Asistencia asistencia);

    Asistencia actualizar(Asistencia asistencia);

    Optional<Asistencia> listarPorId(Integer id);

    public void eliminarPorId(Integer id);


<<<<<<< HEAD
    List<Asistencia> listarPorNombreUsuario(String nombreUsuario);

    List<Asistencia> listarPorFecha(LocalDateTime desde, LocalDateTime hasta);

    List<Asistencia> listarPorNombreCurso(String nombreCurso);

    List<UsuarioAsistenciaStatsDto> usuariosConMasFaltas();

    List<UsuarioAsistenciaStatsDto> usuariosConMasTardanzas();

    List<UsuarioAsistenciaStatsDto> usuariosConMasPresentes();
=======
>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
}