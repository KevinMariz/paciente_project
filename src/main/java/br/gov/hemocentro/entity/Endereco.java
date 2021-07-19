package br.gov.hemocentro.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Endereco {
	
	@Column(length = 9)
	private String cep;
	private String logradouro;
	@Column(length = 50)
    private String complemento;
	@Column(length = 75)
	private String bairro;
	@Column(length = 50)
    private String localidade;
	@Column(length = 2)
	private String uf;
	@Column(length = 7)
    private String ibge;
	@Column(length = 4)
    private String gia;
	@Column(length = 2)
    private String ddd;
	@Column(length = 4)
    private String siafi;
	@Column(length = 40)
	private String numero;
	
	public Endereco apiEndereco(String cep, String numero) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://viacep.com.br/ws/"+cep+"/json/";
		ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);
		Endereco endereco = response.getBody();
		endereco.setNumero(numero);
		return endereco;
	}
	
}
