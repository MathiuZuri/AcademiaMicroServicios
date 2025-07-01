package com.example.ms_kajita.service.impl;

import com.example.ms_kajita.dto.*;
import com.example.ms_kajita.entity.Asistencia;
import com.example.ms_kajita.feing.CursoFeing;
import com.example.ms_kajita.feing.DocenteFeing;
import com.example.ms_kajita.feing.PlanAcademicoFeing;
import com.example.ms_kajita.feing.UsuarioFeign;
import com.example.ms_kajita.repository.AsistenciaRepository;
import com.example.ms_kajita.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Autowired
    private UsuarioFeign usuarioFeign; // Correcto: inyectaste catalogoFeign
    @Autowired
    private CursoFeing cursoFeing;
    @Autowired
    private DocenteFeing docenteFeing;
    @Autowired
    private PlanAcademicoFeing planAcademicoFeing;

    @Override
    public List<Asistencia> listar() {
        return asistenciaRepository.findAll().stream()
                .map(asistencia -> {
                    asistencia.setUsuarioNombre(obtenerUsuarioNombre(asistencia.getUsuarioIdUsuario().intValue()));
                    asistencia.setCursoNombre(obtenerCursoNombre(asistencia.getCursoIdCurso()));
                    asistencia.setDocenteNombre(obtenerDocenteNombre(asistencia.getDocenteIdDocente()));
                    asistencia.setPlanAcademicoNombre(obtenerPlanAcademicoNombre(asistencia.getPlanAcademicoIdPlanAcademico()));
                    return asistencia;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Asistencia guardar(Asistencia asistencia) {
        Asistencia asistenciaGuardada = asistenciaRepository.save(asistencia);
        asistenciaGuardada.setUsuarioNombre(obtenerUsuarioNombre(asistenciaGuardada.getUsuarioIdUsuario().intValue()));
        asistenciaGuardada.setCursoNombre(obtenerCursoNombre(asistenciaGuardada.getCursoIdCurso()));
        asistenciaGuardada.setDocenteNombre(obtenerDocenteNombre(asistenciaGuardada.getDocenteIdDocente()));
        asistenciaGuardada.setPlanAcademicoNombre(obtenerPlanAcademicoNombre(asistenciaGuardada.getPlanAcademicoIdPlanAcademico()));
        return asistenciaGuardada;
    }

    @Override
    public Asistencia actualizar(Asistencia asistencia) {
        Asistencia asistenciaActualizada = asistenciaRepository.save(asistencia);
        asistenciaActualizada.setUsuarioNombre(obtenerUsuarioNombre(asistenciaActualizada.getUsuarioIdUsuario().intValue()));
        asistenciaActualizada.setCursoNombre(obtenerCursoNombre(asistenciaActualizada.getCursoIdCurso()));
        asistenciaActualizada.setDocenteNombre(obtenerDocenteNombre(asistenciaActualizada.getDocenteIdDocente()));
        asistenciaActualizada.setPlanAcademicoNombre(obtenerPlanAcademicoNombre(asistenciaActualizada.getPlanAcademicoIdPlanAcademico()));
        return asistenciaActualizada;
    }

    @Override
    public Optional<Asistencia> listarPorId(Integer id) {
        Optional<Asistencia> asistenciaOptional = asistenciaRepository.findById(id);
        if (asistenciaOptional.isPresent()) {
            Asistencia asistencia = asistenciaOptional.get();
            asistencia.setUsuarioNombre(obtenerUsuarioNombre(asistencia.getUsuarioIdUsuario().intValue()));
            asistencia.setCursoNombre(obtenerCursoNombre(asistencia.getCursoIdCurso()));
            asistencia.setDocenteNombre(obtenerDocenteNombre(asistencia.getDocenteIdDocente()));
            asistencia.setPlanAcademicoNombre(obtenerPlanAcademicoNombre(asistencia.getPlanAcademicoIdPlanAcademico()));
            return Optional.of(asistencia);
        }
        return Optional.empty();
    }

    @Override
    public void eliminarPorId(Integer id) {
        asistenciaRepository.deleteById(id);
    }


    private String obtenerUsuarioNombre(Integer idUsuario) {
        try {
            UsuarioDto usuarioDto = usuarioFeign.buscarUsuario(idUsuario).getBody();
            if (usuarioDto != null) {
                return usuarioDto.getUser();
            }
        } catch (Exception e) {
            return "Usuario no encontrado";
        }
        return null;
    }

    private String obtenerCursoNombre(Integer idCurso) {
        try {
            CursoDto cursoDto = cursoFeing.buscarCurso(idCurso).getBody();
            if (cursoDto != null) {
                return cursoDto.getNombre();
            }
        } catch (Exception e) {
            return "Curso no encontrado";
        }
        return null;
    }

    private String obtenerDocenteNombre(Integer idDocente) {
        try {
            DocenteDto docenteDto = docenteFeing.buscarDocente(idDocente).getBody();
            if (docenteDto != null) {
                return docenteDto.getNombre();
            }
        } catch (Exception e) {
            return "Docente no encontrado";
        }
        return null;
    }

    private String obtenerPlanAcademicoNombre(Integer idPlan) {
        try {
            PlanAcademicoDto planAcademicoDto = planAcademicoFeing.buscarPlanAcademico(idPlan).getBody();
            if (planAcademicoDto != null) {
                return planAcademicoDto.getNombrePlan();
            }
        } catch (Exception e) {
            return "Plan académico no encontrado";
        }
        return null;
    }

    // Helper para enriquecer nombres
    private Asistencia enriquecer(Asistencia a) {
        a.setUsuarioNombre(obtenerUsuarioNombre(a.getUsuarioIdUsuario().intValue()));
        a.setCursoNombre(obtenerCursoNombre(a.getCursoIdCurso()));
        a.setDocenteNombre(obtenerDocenteNombre(a.getDocenteIdDocente()));
        a.setPlanAcademicoNombre(obtenerPlanAcademicoNombre(a.getPlanAcademicoIdPlanAcademico()));
        return a;
    }

    @Override
    public List<Asistencia> listarPorNombreUsuario(String nombreUsuario) {
        // filtrado en memoria sobre el listado enriquecido
        return listar().stream()
                .filter(a -> a.getUsuarioNombre()
                        .toLowerCase()
                        .contains(nombreUsuario.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Asistencia> listarPorFecha(LocalDateTime desde, LocalDateTime hasta) {
        return asistenciaRepository
                .findByFechaRegistroAsistenciaBetween(desde, hasta)
                .stream()
                .map(this::enriquecer)
                .collect(Collectors.toList());
    }

    @Override
    public List<Asistencia> listarPorNombreCurso(String nombreCurso) {
        return listar().stream()
                .filter(a -> a.getCursoNombre()
                        .toLowerCase()
                        .contains(nombreCurso.toLowerCase()))
                .collect(Collectors.toList());
    }

    // MÉTODOS DE ESTADÍSTICAS
    private Map<Long, UsuarioAsistenciaStatsDto> agruparStats() {
        Map<Long, UsuarioAsistenciaStatsDto> stats = new HashMap<>();
        listar().forEach(a -> {
            Long uid = a.getUsuarioIdUsuario();
            stats.computeIfAbsent(uid, id -> {
                UsuarioAsistenciaStatsDto dto = new UsuarioAsistenciaStatsDto();
                dto.setUsuarioId(id);
                dto.setUsuarioNombre(a.getUsuarioNombre());
                return dto;
            });
            UsuarioAsistenciaStatsDto dto = stats.get(uid);
            switch (a.getEstadoAsistencia().toLowerCase()) {
                case "falta":    dto.setFaltas(dto.getFaltas() + 1);    break;
                case "tardanza": dto.setTardanzas(dto.getTardanzas() + 1); break;
                case "presente": dto.setPresentes(dto.getPresentes() + 1); break;
            }
        });
        return stats;
    }

    @Override
    public List<UsuarioAsistenciaStatsDto> usuariosConMasFaltas() {
        return agruparStats().values().stream()
                .sorted(Comparator.comparingLong(UsuarioAsistenciaStatsDto::getFaltas).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioAsistenciaStatsDto> usuariosConMasTardanzas() {
        return agruparStats().values().stream()
                .sorted(Comparator.comparingLong(UsuarioAsistenciaStatsDto::getTardanzas).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioAsistenciaStatsDto> usuariosConMasPresentes() {
        return agruparStats().values().stream()
                .sorted(Comparator.comparingLong(UsuarioAsistenciaStatsDto::getPresentes).reversed())
                .collect(Collectors.toList());
    }

}