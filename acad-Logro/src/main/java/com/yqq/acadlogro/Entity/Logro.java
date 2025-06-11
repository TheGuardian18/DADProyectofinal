package com.yqq.acadlogro.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "logros")
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private Long institucionId;
}