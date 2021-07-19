package br.gov.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.hemocentro.entity.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
