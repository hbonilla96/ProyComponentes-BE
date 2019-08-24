package com.cenfotec.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.proyecto.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	List<Board> findByUserName(String idUser);
}