package br.gov.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.hemocentro.entity.Patologia;

public interface PatologiaRepository extends JpaRepository<Patologia, String> {
	
}
