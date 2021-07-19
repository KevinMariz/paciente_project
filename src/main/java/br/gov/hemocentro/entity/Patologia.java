package br.gov.hemocentro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "patologia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patologia {
	
	@Id
	@Column(length = 6)
	private String codigo;
	
	private String nome;

}
