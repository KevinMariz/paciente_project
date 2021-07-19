package br.gov.hemocentro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.ClassificacaoRisco;
import br.gov.hemocentro.service.ClassificacaoRiscoService;

@RestController
@RequestMapping("/classificacao-risco")
public class ClassificacaoRiscoController {
	
	@Autowired
	ClassificacaoRiscoService classificacaoRiscoService; 
	
	@GetMapping("/{id}")
	public ResponseEntity<ClassificacaoRisco> getByClassificacaoRisco(@PathVariable("id") Long id){
		return ResponseEntity.ok(classificacaoRiscoService.get(id));
	}

}
