package com.cenfotec.proyecto.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.proyecto.domain.Board;
import com.cenfotec.proyecto.repository.BoardRepository;


@RestController 
@RequestMapping("/board")
public class BoardController {

	private BoardRepository repository;

	BoardController(BoardRepository tableroRepository) {       
		  this.repository = tableroRepository;   
	}
	  
	  @GetMapping({"/admin"}) 
	  public List findAll(){   
		  return repository.findAll(); 
	  }
	  
	  @GetMapping(path = {"/board"})
	   public List<Board> findByUserName(@PathVariable String userName){
	       List<Board> division = repository.findByUserName(userName);
		        return division;
	  }	
	  
	  @PostMapping
	  public Board create(@RequestBody Board tablero){     
		  return repository.save(tablero); 
	  }
	  
}