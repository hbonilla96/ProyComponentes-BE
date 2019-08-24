package com.cenfotec.proyecto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	private String name;

	private String description;
	
	private String category;
	
	private Long idPin;

	private String userName;
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}

	public String getCategory() {
		return this.category;
	}
	
	public String getUserName(){
		return this.userName;
	}

}