package br.edu.unifacear.entidade;

public class Compra {

	private int id;
	private String idcliente;
	private String idveiculo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdveiculo() {
		return idveiculo;
	}

	public void setIdveiculo(String idveiculo) {
		this.idveiculo = idveiculo;
	}

	public Compra(int id, String idcliente, String idveiculo) {
		super();
		this.id = id;
		this.idcliente = idcliente;
		this.idveiculo = idveiculo;
	}

	public Compra() {
		super();
	}

}
