package com.yqq.acadlogro.Servicio.ServicioImpl;

import com.yqq.acadlogro.Dto.InstitucionDto;
import com.yqq.acadlogro.Entity.Logro;
import com.yqq.acadlogro.Feign.InstitucionFeign;
import com.yqq.acadlogro.Repository.LogroRepository;
import com.yqq.acadlogro.Servicio.LogroServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class LogroServicioImpl implements LogroServicio {

    private final LogroRepository logroRepository;
    private final InstitucionFeign institucionFeign;

    @Override
    public List<Logro> listarLogros() {
        return logroRepository.findAll();
    }

    @Override
    public Logro obtenerLogroPorId(Long id) {
        return logroRepository.findById(id).orElse(null);
    }

    @Override
    public Logro guardarLogro(Logro logro) {
        // Validar si la institución existe antes de guardar
        ResponseEntity<InstitucionDto> response = institucionFeign.getInstitucion(logro.getInstitucionId());

        if (response.getBody() == null || response.getBody().getNombre() == null) {
            throw new RuntimeException("Institución no encontrada. No se puede guardar el logro.");
        }

        return logroRepository.save(logro);
    }

    @Override
    public void eliminarLogro(Long id) {
        logroRepository.deleteById(id);
    }
}