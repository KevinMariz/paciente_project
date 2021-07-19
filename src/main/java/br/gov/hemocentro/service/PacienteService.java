package br.gov.hemocentro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.hemocentro.entity.Paciente;
import br.gov.hemocentro.exception.NotFoundException;
import br.gov.hemocentro.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	public Paciente getById(String prontuario) {
		Optional<Paciente> paciente = pacienteRepository.findById(prontuario);
		return paciente.orElseThrow(() -> new NotFoundException("Não há paciente com o prontuario = "+ prontuario));
	}
	
	public List<Paciente> allPacientes() {
		return pacienteRepository.findAll();
	}
	
}
