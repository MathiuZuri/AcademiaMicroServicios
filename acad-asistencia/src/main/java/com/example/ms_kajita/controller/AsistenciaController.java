package com.example.ms_kajita.controller;

<<<<<<< HEAD
import com.example.ms_kajita.dto.UsuarioAsistenciaStatsDto;
import com.example.ms_kajita.entity.Asistencia;
import com.example.ms_kajita.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
=======
import com.example.ms_kajita.entity.Asistencia;
import com.example.ms_kajita.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
import java.util.List;
import java.util.Optional;

@RestController
<<<<<<< HEAD
@RequestMapping("/asistencias")
=======
@RequestMapping("/api/asistencias")
>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public ResponseEntity<List<Asistencia>> listarTodas() {
        List<Asistencia> asistencias = asistenciaService.listar();
        return ResponseEntity.ok(asistencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> obtenerPorId(@PathVariable Integer id) {
        Optional<Asistencia> asistenciaOptional = asistenciaService.listarPorId(id);
        return asistenciaOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asistencia> guardar(@RequestBody Asistencia asistencia) {
        Asistencia nuevaAsistencia = asistenciaService.guardar(asistencia);
        return ResponseEntity.ok(nuevaAsistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> actualizar(@PathVariable Integer id, @RequestBody Asistencia asistencia) {
        if (!asistenciaService.listarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        asistencia.setIdAsistencia(id); // Asegura que se actualice el registro correcto
        Asistencia asistenciaActualizada = asistenciaService.actualizar(asistencia);
        return ResponseEntity.ok(asistenciaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!asistenciaService.listarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        asistenciaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD
    // --- FILTROS ---

    @GetMapping("/buscar-usuario")
    public ResponseEntity<List<Asistencia>> listarPorNombreUsuario(
            @RequestParam String nombre) {
        List<Asistencia> list = asistenciaService.listarPorNombreUsuario(nombre);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar-curso")
    public ResponseEntity<List<Asistencia>> listarPorNombreCurso(
            @RequestParam String nombre) {
        List<Asistencia> list = asistenciaService.listarPorNombreCurso(nombre);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar-fecha")
    public ResponseEntity<List<Asistencia>> listarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        List<Asistencia> list = asistenciaService.listarPorFecha(desde, hasta);
        return ResponseEntity.ok(list);
    }

    // --- ESTADÍSTICAS ---

    @GetMapping("/stats/faltas")
    public ResponseEntity<List<UsuarioAsistenciaStatsDto>> usuariosConMasFaltas() {
        return ResponseEntity.ok(asistenciaService.usuariosConMasFaltas());
    }

    @GetMapping("/stats/tardanzas")
    public ResponseEntity<List<UsuarioAsistenciaStatsDto>> usuariosConMasTardanzas() {
        return ResponseEntity.ok(asistenciaService.usuariosConMasTardanzas());
    }

    @GetMapping("/stats/presentes")
    public ResponseEntity<List<UsuarioAsistenciaStatsDto>> usuariosConMasPresentes() {
        return ResponseEntity.ok(asistenciaService.usuariosConMasPresentes());
    }
=======
>>>>>>> c28b2f9cf57a2083a88e90964b001d42b556217e
}
