package com.yqq.acadcomunicado.Feign;

import com.yqq.acadcomunicado.Dto.InstitucionDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "acad-institucion-service", path = "/institucion")
public interface InstitucionFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "institucionBuscarCB", fallbackMethod = "fallbackBuscarInstitucion")
    ResponseEntity<InstitucionDto> getInstitucion(@PathVariable("id") Long id);

    default ResponseEntity<InstitucionDto> fallbackBuscarInstitucion(Long id, Throwable e) {
        InstitucionDto fallback = new InstitucionDto();
        fallback.setNombre("Servicio de Institución no disponible");
        fallback.setDireccion("Sin conexión");
        return ResponseEntity.ok(fallback);
    }
}