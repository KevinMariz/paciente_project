package br.gov.hemocentro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.Paciente;
import br.gov.hemocentro.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Paciente>> allPacientes(){
		return ResponseEntity.ok(pacienteService.allPacientes());
	}
	
	@GetMapping("/{prontuario}")
	public ResponseEntity<Paciente> getByPaciente(@PathVariable("prontuario") String prontuario){
		return ResponseEntity.ok(pacienteService.getById(prontuario));
	}
	
}
