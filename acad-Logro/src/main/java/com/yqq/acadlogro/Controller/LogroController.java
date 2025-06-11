package com.yqq.acadlogro.Controller;

import com.yqq.acadlogro.Dto.InstitucionDto;
import com.yqq.acadlogro.Entity.Logro;
import com.yqq.acadlogro.Feign.InstitucionFeign;
import com.yqq.acadlogro.Servicio.LogroServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logro")
@RequiredArgsConstructor
public class LogroController {

    private final LogroServicio logroServicio;
    private final InstitucionFeign institucionFeign;

    @GetMapping
    public ResponseEntity<List<Logro>> listarLogros() {
        return ResponseEntity.ok(logroServicio.listarLogros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logro> obtenerLogro(@PathVariable Long id) {
        Logro logro = logroServicio.obtenerLogroPorId(id);
        if (logro == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(logro);
    }

    @PostMapping
    public ResponseEntity<Logro> guardarLogro(@RequestBody Logro logro) {
        return ResponseEntity.ok(logroServicio.guardarLogro(logro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogro(@PathVariable Long id) {
        logroServicio.eliminarLogro(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Extra: Logro + Institución
    @GetMapping("/{id}/detalle")
    public ResponseEntity<Map<String, Object>> detalleLogro(@PathVariable Long id) {
        Logro logro = logroServicio.obtenerLogroPorId(id);
        if (logro == null) return ResponseEntity.notFound().build();

        ResponseEntity<InstitucionDto> institucionResponse = institucionFeign.getInstitucion(logro.getInstitucionId());
        InstitucionDto institucion = institucionResponse.getBody();

        Map<String, Object> response = new HashMap<>();
        response.put("logro", logro);
        response.put("institucion", institucion);

        return ResponseEntity.ok(response);
    }
}