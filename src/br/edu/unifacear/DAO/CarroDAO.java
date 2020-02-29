package br.edu.unifacear.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Carro;

public class CarroDAO extends Dao<Carro> {

	public Carro inserir(Carro carro) throws Exception {
		Connection con = Conectar();
		String sql = "INSERT INTO veiculo(modelo,montadora,valor) VALUES(?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, carro.getModelo());
			stmt.setString(2, carro.getMontadora());
			stmt.setBigDecimal(3, carro.getValor());

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return carro;
	}

	public List<Carro> listar() throws Exception {
		Connection con = Conectar();

		List<Carro> carros = new ArrayList();

		String sql = "select * from veiculo";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Carro listaCarro = new Carro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
				carros.add(listaCarro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return carros;
	}

	public Carro alterar(int id, Carro carro) throws Exception {
		
		Connection con = Conectar();
		String sql = "update veiculo set modelo = ?, montadora = ?, valor = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, carro.getModelo());
			stmt.setString(2, carro.getMontadora());
			stmt.setBigDecimal(3, carro.getValor());
			stmt.setInt(4, id);


			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		return null;
	}

	@Override
	public Carro excluir(int id) throws Exception {
		
		Connection con = Conectar();
		String sql = "delete from veiculo where id = ?";
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
	public Carro buscarPorId(Integer id) throws Exception {
		Connection con = Conectar();
		
		String query = "select * from veiculo where id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		return null;
	}
}
