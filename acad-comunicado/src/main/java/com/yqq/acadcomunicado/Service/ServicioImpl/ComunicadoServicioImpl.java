package com.yqq.acadcomunicado.Service.ServicioImpl;


import com.yqq.acadcomunicado.Dto.InstitucionDto;
import com.yqq.acadcomunicado.Entity.Comunicado;
import com.yqq.acadcomunicado.Feign.InstitucionFeign;
import com.yqq.acadcomunicado.Repository.ComunicadoRepository;
import com.yqq.acadcomunicado.Service.ComunicadoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComunicadoServicioImpl implements ComunicadoServicio {

    private final ComunicadoRepository comunicadoRepository;
    private final InstitucionFeign institucionFeign;

    @Override
    public List<Comunicado> listarComunicados() {
        return comunicadoRepository.findAll();
    }

    @Override
    public Comunicado buscarPorId(Long id) {
        return comunicadoRepository.findById(id).orElse(null);
    }

    @Override
    public Comunicado guardarComunicado(Comunicado comunicado) {
        // Aquí podrías validar que la institución exista usando Feign
        InstitucionDto institucionDto = institucionFeign.getInstitucion(comunicado.getIdInstitucion()).getBody();

        if (institucionDto == null || institucionDto.getIdInstitucion() == null) {
            throw new RuntimeException("Institución no encontrada con ID: " + comunicado.getIdInstitucion());
        }

        return comunicadoRepository.save(comunicado);
    }

    @Override
    public void eliminarComunicado(Long id) {
        comunicadoRepository.deleteById(id);
    }
}