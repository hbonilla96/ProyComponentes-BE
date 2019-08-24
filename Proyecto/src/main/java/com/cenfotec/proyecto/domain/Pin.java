package com.cenfotec.proyecto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	private String name;

	private String description;

	private String urlImage;

	private String urlSite;

	private Long idBoard;
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}

	public String getUrlImage() {
		return this.urlImage;
	}
	
	public String getUrlSite() {
		return this.urlImage;
	}

}