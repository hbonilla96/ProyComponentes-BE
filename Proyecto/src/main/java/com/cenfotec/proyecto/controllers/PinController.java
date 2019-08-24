package com.cenfotec.proyecto.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.proyecto.domain.Pin;
import com.cenfotec.proyecto.repository.PinRepository;


@RestController 
@RequestMapping({"/pin"}) 
public class PinController {

	private PinRepository repository;

	PinController(PinRepository pinRepository) {       
		  this.repository = pinRepository;   
	}
	
	  @GetMapping 
	  public List findAll(){   
		  return repository.findAll(); 
	  }
	  
	  @GetMapping(path = {"/{idBoard}"})
	   public List<Pin> findByUserName(@PathVariable Long idBoard){
	       List<Pin> pin = repository.findByIdBoard(idBoard);
		        return pin;
	  }	
	  
	  @PostMapping 
	  public Pin create(@RequestBody Pin pin){     
		  return repository.save(pin); 
	  }
	  
}
