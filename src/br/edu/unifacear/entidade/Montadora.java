package br.edu.unifacear.entidade;

import java.math.BigDecimal;

public class Montadora {
	
	private int id;
	private String montadora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	
	public Montadora() {}
	public Montadora(int id, String montadora) {
		super();
		this.id = id;
		this.montadora = montadora;
	}

}
