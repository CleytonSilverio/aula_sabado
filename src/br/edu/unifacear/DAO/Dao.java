package br.edu.unifacear.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class Dao<T> {
	
	public Connection Conectar() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/aula_sabado", "root", "");
		return conn;
	}
	
	public abstract T inserir(T t) throws Exception;

	public abstract T alterar(int id , T t) throws Exception;

	public abstract T excluir(int id) throws Exception;

	public abstract List<T> listar() throws Exception;

	public abstract T buscarPorId(Integer id) throws Exception;


}
