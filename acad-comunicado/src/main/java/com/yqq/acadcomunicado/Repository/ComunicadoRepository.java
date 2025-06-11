package com.yqq.acadcomunicado.Repository;

import com.yqq.acadcomunicado.Entity.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
}