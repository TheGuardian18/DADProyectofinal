package com.yqq.acadcomunicado.Controller;


import com.yqq.acadcomunicado.Entity.Comunicado;
import com.yqq.acadcomunicado.Service.ComunicadoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunicados")
@RequiredArgsConstructor
public class ComunicadoController {

    private final ComunicadoServicio comunicadoServicio;

    @GetMapping
    public ResponseEntity<List<Comunicado>> listar() {
        return ResponseEntity.ok(comunicadoServicio.listarComunicados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunicado> buscar(@PathVariable Long id) {
        Comunicado comunicado = comunicadoServicio.buscarPorId(id);
        if (comunicado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comunicado);
    }

    @PostMapping
    public ResponseEntity<Comunicado> guardar(@RequestBody Comunicado comunicado) {
        return ResponseEntity.ok(comunicadoServicio.guardarComunicado(comunicado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        comunicadoServicio.eliminarComunicado(id);
        return ResponseEntity.noContent().build();
    }
}