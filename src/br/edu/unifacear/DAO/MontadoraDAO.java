package br.edu.unifacear.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Carro;
import br.edu.unifacear.entidade.Montadora;

public class MontadoraDAO extends Dao<Montadora> {

	private static List<Montadora> montadoras = new ArrayList<Montadora>();

	public Montadora inserir(Montadora montadora) throws Exception {
		Connection con = Conectar();
		String sql = "INSERT INTO montadora(montadora) VALUES(?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, montadora.getMontadora());

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return montadora;
	}

	@Override
	public Montadora alterar(int id, Montadora montadora) throws Exception {
		
		Connection con = Conectar();
		String sql = "update montadora set montadora = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, montadora.getMontadora());
			stmt.setInt(2, id);


			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		
		return null;
	}

	@Override
	public Montadora excluir(int id) throws Exception {
		
		Connection con = Conectar();
		String sql = "delete from montadora where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		return null;
	}

	@Override
	public List<Montadora> listar() throws Exception {
		
		Connection con = Conectar();

		List<Montadora> montadoras = new ArrayList();

		String sql = "select * from montadora";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Montadora listaMontadora = new Montadora(rs.getInt(1), rs.getString(2));
				montadoras.add(listaMontadora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return montadoras;
	}

	@Override
	public Montadora buscarPorId(Integer id) throws Exception {

		Connection con = Conectar();

		String query = "select * from montadora where id = ?";
		PreparedStatement stmt = con.prepareStatement(query);

		return null;
	}

}
