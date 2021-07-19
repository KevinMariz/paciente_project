package br.gov.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.hemocentro.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String>{

}
