package com.cenfotec.proyecto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tablero {

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	private Long id; 
	private String nombre;   
	private String descripcion;
	private Long idPin;
	
}
