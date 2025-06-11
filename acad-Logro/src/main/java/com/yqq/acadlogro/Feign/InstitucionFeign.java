package com.yqq.acadlogro.Feign;

import com.yqq.acadlogro.Dto.InstitucionDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "acad-institucion", path = "/institucion")
public interface InstitucionFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "institucionBuscarCB", fallbackMethod = "fallbackBuscarInstitucion")
    ResponseEntity<InstitucionDto> getInstitucion(@PathVariable("id") Long id);

    // Fallback en caso de fallo en la conexión
    default ResponseEntity<InstitucionDto> fallbackBuscarInstitucion(Long id, Throwable e) {
        InstitucionDto fallback = new InstitucionDto();
        fallback.setNombre("Servicio de INSTITUCION no disponible");
        fallback.setDireccion("N/A");
        return ResponseEntity.ok(fallback);
    }
}