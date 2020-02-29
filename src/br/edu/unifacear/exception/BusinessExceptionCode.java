package br.edu.unifacear.exception;

public enum BusinessExceptionCode {
	
	ERR001("Não foi possivel realizar a inserção (Verifique o Banco de dados)."),
	ERR002("O login está inválido."),
	ERR003("Modelo possui caracteres inválidos."),
	ERR004("Montadora possui catacteres inválidos.");
	
	private final String message;
	
	private BusinessExceptionCode(final String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
