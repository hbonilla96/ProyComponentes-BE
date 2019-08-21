package com.cenfotec.proyecto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.proyecto.domain.Board;
import com.cenfotec.proyecto.repository.BoardRepository;


@RestController 
@RequestMapping({"/tablero"}) 
public class BoardController {

	private BoardRepository repository;

	BoardController(BoardRepository tableroRepository) {       
		  this.repository = tableroRepository;   
	}
	
	  @GetMapping 
	  public List findAll(){   
		  return repository.findAll(); 
	  }
	  
	  @GetMapping(path = {"/{id}"}) 
	  public ResponseEntity<Board> findById(@PathVariable long id){   
		  return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build()); 
	  }
	  
	  @PostMapping 
	  public Board create(@RequestBody Board tablero){     
		  return repository.save(tablero); 
	  }
	  
}