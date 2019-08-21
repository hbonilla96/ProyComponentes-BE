package com.cenfotec.proyecto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Usuario {

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	private Long id; 
	private String nombre;   
	private String contrasenna;   
	private Long idTablero;
	
}
