package br.edu.unifacear.exception;

public class BusinessException extends Exception{
	
	private BusinessExceptionCode code;
	
	public BusinessException(BusinessExceptionCode code) {
		super(code.getMessage());
		this.code = code;
	}
	
	public BusinessExceptionCode getCode() {
		return code;
	}

}
