package br.gov.hemocentro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Comorbidade;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.ComorbidadeRepository;

@Service
public class ComorbidadeService {
	
	@Autowired
	ComorbidadeRepository comorbidadeRepository;
	
	public Comorbidade create(Comorbidade comorbidade) {
		return  comorbidadeRepository.save(comorbidade);
	}
	
	public Comorbidade update(Comorbidade comorbidade, Long id) {
		comorbidade.setId(id);
		return comorbidadeRepository.save(comorbidade);
	}
	
	public Comorbidade get(Long id) {
		Optional<Comorbidade> optional = comorbidadeRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Comorbidade não encontrada."));
	}
	
	public List<Comorbidade> all() {
		return comorbidadeRepository.findAll();
	}

}
