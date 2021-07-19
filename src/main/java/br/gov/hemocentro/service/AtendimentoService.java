package br.gov.hemocentro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Atendimento;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	public Atendimento create(Atendimento classificacaoRisco) {
		return atendimentoRepository.save(classificacaoRisco);
	}
	
	public Atendimento update(Atendimento classificacaoRisco, Long id) {
		classificacaoRisco.setId(id);
		return atendimentoRepository.save(classificacaoRisco);
	}
	
	public Atendimento get(Long id) {
		Optional<Atendimento> optional = atendimentoRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Classificação não encontrada."));
	}
}
