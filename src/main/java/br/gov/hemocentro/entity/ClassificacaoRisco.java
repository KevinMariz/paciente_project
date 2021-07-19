package br.gov.hemocentro.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.gov.hemocentro.entity.enums.ClassificacaoEnum;
import br.gov.hemocentro.entity.enums.EncaminharEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "classificacao_risco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString	
public class ClassificacaoRisco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 3)
	private int temperatura;
	@Column(length = 3)
	private int frequencia_respiratoria;
	@Column(length = 3)
	private int frequencia_cardiaca;
	@Column(length = 3)
	private int spo2;
	@Column(length = 3)
	private int pressao_arterial;
	
	@Column(length = 150)
	private String alergias;
	@Column(length = 150)
	private String medicamentos;
	@Column(length = 255)
	@Lob
	private String queixa_principal;
	
	@Enumerated(EnumType.STRING)
	private ClassificacaoEnum classificacao;
	
	@Enumerated(EnumType.STRING)
	private EncaminharEnum encaminhar;
	
	private LocalDate data_classificacao;
	private LocalTime hr_inicio;
	private LocalTime hr_termino;
	
	@OneToMany
	private List<Sintoma> sintomas = new ArrayList<>();
	
	@OneToMany
	private List<Comorbidade> Comorbidades = new ArrayList<>();;
	
	@ManyToOne
	private Paciente paciente;
	
}
