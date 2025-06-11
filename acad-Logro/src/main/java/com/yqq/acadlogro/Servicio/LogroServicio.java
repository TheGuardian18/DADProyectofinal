package com.yqq.acadlogro.Servicio;

import com.yqq.acadlogro.Entity.Logro;

import java.util.List;

public interface LogroServicio {

    List<Logro> listarLogros();
    Logro obtenerLogroPorId(Long id);
    Logro guardarLogro(Logro logro);
    void eliminarLogro(Long id);
}