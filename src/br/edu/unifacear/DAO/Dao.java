package br.edu.unifacear.DAO;

import java.util.List;

public abstract class Dao<T> {
	
	public abstract T inserir(T t);

	public abstract T alterar(T t);

	public abstract T excluir(T t);

	public abstract List<T> listar();

	public abstract T buscarPorId(Integer id);


}
