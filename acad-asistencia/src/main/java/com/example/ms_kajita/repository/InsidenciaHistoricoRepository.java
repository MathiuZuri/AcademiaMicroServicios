package com.example.ms_kajita.repository;

import com.example.ms_kajita.entity.Asistencia;
import com.example.ms_kajita.entity.InsidenciaHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InsidenciaHistoricoRepository extends JpaRepository<InsidenciaHistorico, Integer> {
    // Listar por fecha
    List<Asistencia> findByFechaRegistroAsistenciaBetween(LocalDateTime desde, LocalDateTime hasta);

    // Listar por usuario (id)
    List<Asistencia> findByUsuarioIdUsuario(Long usuarioIdUsuario);

    // Listar por curso (id)
    List<Asistencia> findByCursoIdCurso(Integer cursoIdCurso);
}