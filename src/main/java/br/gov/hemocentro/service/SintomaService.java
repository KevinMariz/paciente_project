package br.gov.hemocentro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Sintoma;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.SintomaRepository;

@Service
public class SintomaService {
	
	@Autowired
	SintomaRepository sintomaRepository;
	
	public Sintoma create(Sintoma sintoma) {
		return  sintomaRepository.save(sintoma);
	}
	
	public Sintoma update(Sintoma sintoma, Long id) {
		sintoma.setId(id);
		return sintomaRepository.save(sintoma);
	}
	
	public Sintoma get(Long id) {
		Optional<Sintoma> optional = sintomaRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Sintoma não encontrada."));
	}
	
	public List<Sintoma> all() {
		return sintomaRepository.findAll();
	}
}
