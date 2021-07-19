package br.gov.hemocentro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.gov.hemocentro.entity.ClassificacaoRisco;
import br.gov.hemocentro.entity.Endereco;
import br.gov.hemocentro.entity.Paciente;
import br.gov.hemocentro.entity.Patologia;
import br.gov.hemocentro.entity.enums.ClassificacaoEnum;
import br.gov.hemocentro.entity.enums.EncaminharEnum;
import br.gov.hemocentro.entity.enums.EtniaEnum;
import br.gov.hemocentro.entity.enums.SexoEnum;
import br.gov.hemocentro.repository.PacienteRepository;
import br.gov.hemocentro.service.ClassificacaoRiscoService;
import br.gov.hemocentro.service.PatologiaService;

@SpringBootApplication
public class PacienteProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PatologiaService patologiaService, 
								PacienteRepository pacienteRepository,
								ClassificacaoRiscoService classificacaoRiscoService) {
		return args -> {
			Endereco endereco = new Endereco();
			Paciente paciente = new Paciente();
			ClassificacaoRisco classificacaoRisco = new ClassificacaoRisco();		

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Patologia[]> patologias = restTemplate.getForEntity("https://cid.api.mokasoft.org/cid10", Patologia[].class);
			
			if (patologias.getBody().length > patologiaService.count()) {
				patologiaService.deleteAll();
			}
			
			if (patologiaService.count() == 0) {
				for (Patologia patologia : patologias.getBody()) {
					patologiaService.save(patologia);
				}
			}

			if (pacienteRepository.count() == 0) {
				paciente.setProntuario("00001");
				paciente.setEtnia(EtniaEnum.CAFUZO);
				paciente.setSexo(SexoEnum.MASCULINO);
				paciente.setNome("Kevin Mariz Macedo");
				paciente.setRg("303848");
				paciente.setSus("00000000000001");
				paciente.setNome_pai("Rivaldo Macedo");
				paciente.setNome_mae("Maria Olivia Mariz");
				paciente.setTelefone("83976484102");
				paciente.setCelular("83958513456");
				paciente.setEmail("kevinmariz@hotmail.com");
				paciente.setObservacoes(
						"Evidentemente, o julgamento imparcial das eventualidades possibilita uma melhor visão global das direções preferenciais no sentido do progresso.");
				paciente.setData_nascimento(LocalDate.of(1995, 06, 2));
				paciente.setData_registro(LocalDateTime.now());
				paciente.addPatologia(patologiaService.get("A00"));
				paciente.addPatologia(patologiaService.get("A02"));
				paciente.setEndereco(endereco.apiEndereco("58056650", "140"));
				paciente.setAtivo(true);
				pacienteRepository.save(paciente);
				}
			
			if (classificacaoRiscoService.count() == 0) {
				classificacaoRisco.setTemperatura(36);
				classificacaoRisco.setFrequencia_respiratoria(100);
				classificacaoRisco.setFrequencia_cardiaca(100);
				classificacaoRisco.setSpo2(100);
				classificacaoRisco.setPressao_arterial(100);
				classificacaoRisco.setAlergias("");
				classificacaoRisco.setMedicamentos("");
				classificacaoRisco.setQueixa_principal("");
				classificacaoRisco.setClassificacao(ClassificacaoEnum.VERMELHO);
				classificacaoRisco.setEncaminhar(EncaminharEnum.MEDICO);
				classificacaoRisco.setData_classificacao(LocalDate.now());
				classificacaoRisco.setHr_inicio(LocalTime.of(11, 30, 0));
				classificacaoRisco.setHr_termino(LocalTime.now());
				classificacaoRisco.setPaciente(pacienteRepository.findById("00001").get());
				classificacaoRiscoService.create(classificacaoRisco);
			}
		};
	}

}
