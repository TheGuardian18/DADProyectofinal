package com.yqq.acadcomunicado.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comunicado")
public class Comunicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asunto;
    private String descripcion;

    private Long idInstitucion;
}