package br.gov.hemocentro.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "atendimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString	
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 4)
	private String senha_dia;
	
	private boolean desistiu;
	
	private LocalDate dt_atend;
	private LocalTime hr_inicio;
	private LocalTime hr_termino;
	
	@OneToOne
	private ClassificacaoRisco classificacao_risco;
	
	public Atendimento(LocalTime hr_inicio, ClassificacaoRisco classificacao_risco) {
		setDt_atend(LocalDate.now());
		setHr_inicio(hr_inicio);
		setHr_termino(LocalTime.now());
		setClassificacao_risco(classificacao_risco);
	}

}
