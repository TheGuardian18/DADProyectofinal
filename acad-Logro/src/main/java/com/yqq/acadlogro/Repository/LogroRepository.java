package com.yqq.acadlogro.Repository;

import com.yqq.acadlogro.Entity.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogroRepository extends JpaRepository<Logro, Long> {
}