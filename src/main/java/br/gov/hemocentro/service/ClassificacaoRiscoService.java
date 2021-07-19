package br.gov.hemocentro.service;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Atendimento;
import br.gov.hemocentro.entity.ClassificacaoRisco;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.ClassificacaoRiscoRepository;

@Service
public class ClassificacaoRiscoService {

	@Autowired
	ClassificacaoRiscoRepository classificacaoRiscoRepository;
	
	@Autowired
	AtendimentoService atendimentoService;
	
	public ClassificacaoRisco create(ClassificacaoRisco classificacaoRisco) {
		ClassificacaoRisco classificacao =  classificacaoRiscoRepository.save(classificacaoRisco);
		atendimentoService.create(new Atendimento(LocalTime.now(), classificacao));
		return classificacao;
	}
	
	public ClassificacaoRisco update(ClassificacaoRisco classificacaoRisco, Long id) {
		classificacaoRisco.setId(id);
		return classificacaoRiscoRepository.save(classificacaoRisco);
	}
	
	public ClassificacaoRisco get(Long id) {
		Optional<ClassificacaoRisco> optional = classificacaoRiscoRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Classificação não encontrada."));
	}
	
	public Long count() {
		return classificacaoRiscoRepository.count();
	}
	
}
