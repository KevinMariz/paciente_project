package br.gov.hemocentro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Patologia;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.PatologiaRepository;

@Service
public class PatologiaService {

	@Autowired
	PatologiaRepository patologiaRepository;
	
	public Patologia save(Patologia patologia) {
		return patologiaRepository.save(patologia);
	}
	
	public void deleteAll() {
		patologiaRepository.deleteAll();
	}
	
	public long count() {
		return patologiaRepository.count();
	}

	public Patologia get(String codigo) {
		Optional<Patologia> optional = patologiaRepository.findById(codigo);
		return optional.orElseThrow(() -> new NotFoundException("Patologia não encontrada."));
	}
	
	public List<Patologia> all() {
		return patologiaRepository.findAll();
	}
	
}
