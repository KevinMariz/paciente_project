package br.gov.hemocentro.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import br.gov.hemocentro.entity.enums.EtniaEnum;
import br.gov.hemocentro.entity.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente {

	@Id
	private String prontuario;
	
	@Enumerated(value = EnumType.STRING)
	private EtniaEnum etnia;
	@Enumerated(value = EnumType.STRING)
	private SexoEnum sexo;
	
	
	
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(length = 20, nullable = false)
	private String rg;
	@Column(length = 20, nullable = false)
	private String sus;
	@Column(length = 150)
	private String nome_pai;
	@Column(length = 150, nullable = false)
	private String nome_mae;
	@Column(length = 15)
	private String telefone;
	@Column(length = 15)
	private String celular;
	@Column(length = 100)
	private String email;
	@Column(length = 250)
	@Lob
	private String observacoes;
	@Column(length = 100)
	private String nome_convenio;
	@Column(length = 20)
	private String convenio_registro;
	
	@Column(nullable = false)
	private LocalDate data_nascimento;
	
	@Column(nullable = false)
	private LocalDateTime data_registro;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Patologia> patologias = new ArrayList<Patologia>();
	
	@Embedded
	private Endereco endereco;
	
	@Column(nullable = false)
	private boolean ativo;
	
	public void addPatologia(Patologia patologia) {
		this.patologias.add(patologia);
	}
}
