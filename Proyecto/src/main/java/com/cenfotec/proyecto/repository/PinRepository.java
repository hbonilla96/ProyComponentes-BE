package com.cenfotec.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.proyecto.domain.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
	List<Pin> findByIdBoard(Long idBoard);
}
