package br.gov.hemocentro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.hemocentro.entity.Sintoma;
import br.gov.hemocentro.service.SintomaService;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {
	
	@Autowired
	SintomaService sintomaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Sintoma>> allSintomas(){
		return ResponseEntity.ok(sintomaService.all());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sintoma> getBySintoma(@PathVariable("id") long id){
		return ResponseEntity.ok(sintomaService.get(id));
	}
}
