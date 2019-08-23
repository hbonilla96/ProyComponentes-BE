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

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;
	
	@NotEmpty
	private String urlImage;
	
	@NotEmpty
	private String urlSite;
	
	@NotEmpty
	private Long idBoard;

	@ElementCollection(fetch = FetchType.EAGER)
	@Builder.Default
	private List<String> roles = new ArrayList<>();
	
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