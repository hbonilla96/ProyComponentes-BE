package com.cenfotec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.proyecto.domain.Tablero;

@Repository
public interface TableroRepository extends JpaRepository<Tablero, Long>{

}
