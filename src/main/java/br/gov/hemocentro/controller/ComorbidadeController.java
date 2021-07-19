package br.gov.hemocentro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.Comorbidade;
import br.gov.hemocentro.service.ComorbidadeService;

@RestController
@RequestMapping("/comorbidade")
public class ComorbidadeController {

	@Autowired
	ComorbidadeService comorbidadeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Comorbidade>> allComorbidades(){
		return ResponseEntity.ok(comorbidadeService.all());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comorbidade> getByComorbidade(@PathVariable("id") long id){
		return ResponseEntity.ok(comorbidadeService.get(id));
	}
}
