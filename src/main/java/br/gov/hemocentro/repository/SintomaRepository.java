package br.gov.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.hemocentro.entity.Sintoma;

public interface SintomaRepository extends JpaRepository<Sintoma, Long> {

}
