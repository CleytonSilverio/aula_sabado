package br.edu.unifacear.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Montadora;

public class MontadoraDAO extends Dao<Montadora>{

	private static List<Montadora> montadoras = new ArrayList<Montadora>();
	
	public Montadora inserir(Montadora montadora) {
		montadoras.add(montadora);
		return montadora;
	}

	@Override
	public Montadora alterar(Montadora t) {
		return null;
	}

	@Override
	public Montadora excluir(Montadora t) {
		return null;
	}

	@Override
	public List<Montadora> listar() {
		return montadoras;
	}

	@Override
	public Montadora buscarPorId(Integer id) {
		return null;
	}

}
