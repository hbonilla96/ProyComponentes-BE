package com.cenfotec.proyecto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.proyecto.domain.Tablero;
import com.cenfotec.proyecto.repository.TableroRepository;


@RestController 
@RequestMapping({"/tablero"}) 
public class TableroController {

	private TableroRepository repository;

	TableroController(TableroRepository tableroRepository) {       
		  this.repository = tableroRepository;   
	}
	
	  @GetMapping 
	  public List findAll(){   
		  return repository.findAll(); 
	  }
	  
	  @GetMapping(path = {"/{id}"}) 
	  public ResponseEntity<Tablero> findById(@PathVariable long id){   
		  return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build()); 
	  }
	  
	  @PostMapping 
	  public Tablero create(@RequestBody Tablero tablero){     
		  return repository.save(tablero); 
	  }
	  
}
