package br.gov.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.hemocentro.entity.Comorbidade;

public interface ComorbidadeRepository extends JpaRepository<Comorbidade, Long> {

}
