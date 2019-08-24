package com.cenfotec.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.proyecto.domain.User;
import com.cenfotec.proyecto.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/user"})
public class UserController {

	private UserRepository repository;
	
    @Autowired
    PasswordEncoder passwordEncoder;
    
	public UserController(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	@GetMapping
	public List findAll(){
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<User> findById(@PathVariable long id){
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public User create(@RequestBody User user){
		
		return repository.save(user.builder()
				.username(user.getUsername())
				.password(this.passwordEncoder.encode(user.getPassword()))
				.build()
				);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update (@PathVariable("id") long id, @RequestBody User user){
		return repository.findById(id).map(record -> {
			record.setUsername(user.getUsername());
			record.setLastName(user.getLastName());
			record.setAbout(user.getAbout());
			record.setLocation(user.getLocation());
			User updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
}