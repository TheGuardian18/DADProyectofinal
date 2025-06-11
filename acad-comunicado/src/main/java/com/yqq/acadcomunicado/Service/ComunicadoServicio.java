package com.yqq.acadcomunicado.Service;

import com.yqq.acadcomunicado.Entity.Comunicado;

import java.util.List;

public interface ComunicadoServicio {

    List<Comunicado> listarComunicados();
    Comunicado buscarPorId(Long id);
    Comunicado guardarComunicado(Comunicado comunicado);
    void eliminarComunicado(Long id);}