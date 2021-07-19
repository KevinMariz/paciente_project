package br.gov.hemocentro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.Atendimento;
import br.gov.hemocentro.service.AtendimentoService;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	AtendimentoService atendimentoService; 
	
	@GetMapping("/{id}")
	public ResponseEntity<Atendimento> getByAtendimento(@PathVariable("id") Long id){
		return ResponseEntity.ok(atendimentoService.get(id));
	}
}
