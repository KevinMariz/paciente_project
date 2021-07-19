package br.gov.hemocentro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.Patologia;
import br.gov.hemocentro.service.PatologiaService;

@RestController
@RequestMapping("/patologia")
public class PatologiaController {

	@Autowired
	PatologiaService patologiaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Patologia>> allPatologias(){
		return ResponseEntity.ok(patologiaService.all());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Patologia> allPatologias(@PathVariable("codigo") String codigo){
		return ResponseEntity.ok(patologiaService.get(codigo));
	}
}
