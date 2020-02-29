package br.edu.unifacear.exception;

public enum BusinessExceptionCode {
	
	ERR001("N�o foi possivel realizar a inser��o (Verifique o Banco de dados)."),
	ERR002("O login est� inv�lido."),
	ERR003("Modelo possui caracteres inv�lidos."),
	ERR004("Montadora possui catacteres inv�lidos.");
	
	private final String message;
	
	private BusinessExceptionCode(final String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
