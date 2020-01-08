package br.edu.unifacear.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Carro;

public class CarroDAO {
	
	private static List<Carro> carros = new ArrayList<Carro>(); 

	public Carro inserir (Carro carro) {
		carros.add(carro);
		return carro;
	}
	
	public List<Carro> listar(){
		return carros;
	}
	
	public Carro deletar(Carro carro) {
		return null;
	}
	
	public Carro alterar(Carro carro) {
		return null;
	}
	
	public Carro buscaId(Carro carro) {
		return null;
	}
}
