package br.edu.unifacear.DAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Cliente;

public class ClienteDAO extends Dao<Cliente> {

	private static List<Cliente> clientes = new ArrayList<Cliente>(); 

	public Cliente inserir(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente alterar(Cliente t) {
		return null;
	}

	@Override
	public Cliente excluir(Cliente t) {
		return null;
	}

	@Override
	public List<Cliente> listar() {
		return clientes;
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		return null;
	}

}
