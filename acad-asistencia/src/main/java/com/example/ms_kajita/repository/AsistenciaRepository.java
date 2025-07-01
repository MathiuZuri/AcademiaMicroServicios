package com.example.ms_kajita.repository;

import com.example.ms_kajita.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    // 1. Listar por usuario (ID)
    List<Asistencia> findByUsuarioIdUsuario(Long usuarioId);

    // 2. Listar por curso (ID)
    List<Asistencia> findByCursoIdCurso(Integer cursoId);

    // 3. Listar por rango de fechas
    List<Asistencia> findByFechaRegistroAsistenciaBetween(
            LocalDateTime desde, LocalDateTime hasta);

    // 4. Estadísticas: conteo por usuario y estado
    @Query("SELECT a.usuarioIdUsuario AS usuarioId, a.estadoAsistencia AS estado, COUNT(a) AS cantidad "
            + "FROM Asistencia a "
            + "GROUP BY a.usuarioIdUsuario, a.estadoAsistencia")
    List<UsuarioEstadoCount> countByUsuarioAndEstado();

    interface UsuarioEstadoCount {
        Long getUsuarioId();
        String getEstado();
        Long getCantidad();
    }
=======

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
}