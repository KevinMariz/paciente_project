package br.gov.hemocentro.entity.enums;

public enum EncaminharEnum {

	MEDICO("Médico"),
	PSICO_SOCIAL("Psico-Social"),
	DENTISTA("Dentista"),
	FISIOTERAPIA("Fisioterapeuta"),
	ENFERMAGEM("Enfermeiro"),
	COAGULOPATIAS_HEMOGLOBINOPATIAS("Cadastro de Coagulopatias e Hemoglobinopatias"),
	COLETA_EXAMES("Coleta de Exames");
	
	private String apelido;
	
	EncaminharEnum(String apelido) {
		this.apelido = apelido;
	}
	
	public String getApelido() {
		return this.apelido;
	}

}
