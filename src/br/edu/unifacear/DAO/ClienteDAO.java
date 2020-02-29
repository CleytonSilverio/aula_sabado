package br.edu.unifacear.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.entidade.Cliente;
import br.edu.unifacear.entidade.Compra;

public class ClienteDAO extends Dao<Cliente> {

	public Cliente inserir(Cliente cliente) throws Exception {
		Connection con = Conectar();
		String sql = "INSERT INTO cliente(nome,login,senha) VALUES(?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getLogin());
			stmt.setString(3, cliente.getSenha());

			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return cliente;
	}

	@Override
	public Cliente alterar(int id, Cliente cliente) throws Exception {
		
		Connection con = Conectar();
		String sql = "update cliente set nome = ?, login = ?, senha = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getLogin());
			stmt.setString(3, cliente.getSenha());
			stmt.setInt(4, id);


			stmt.execute(); // executa comando
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		return null;
	}

	@Override
	public Cliente excluir(int id) throws Exception {
		
		Connection con = Conectar();
		String sql = "delete from cliente where id = ?";
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
	public List<Cliente> listar() throws Exception {

		Connection con = Conectar();

		List<Cliente> lista = new ArrayList();

		String sql = "select * from cliente";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente listaUsuario = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				lista.add(listaUsuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public Cliente buscarPorId(Integer id) throws Exception {
		Connection con = Conectar();

		String query = "select * from cliente where id = ?";
		PreparedStatement stmt = con.prepareStatement(query);

		return null;
	}
	
	public Cliente comprar(int cliente, int carro) throws Exception {
		Connection con = Conectar();
		
		
		String sql = "INSERT INTO compra(idcliente,idveiculo) VALUES(?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);


			stmt.setInt(1, cliente);
			stmt.setInt(2, carro);

			stmt.execute(); // executa comando
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		
		return null;
	}
	
	public List<Compra> listarCompras() throws Exception {
		Connection con = Conectar();

		List<Compra> listacompra = new ArrayList();

		String sql = "SELECT compra.id, cliente.nome, veiculo.modelo FROM compra INNER JOIN cliente ON compra.idcliente = cliente.id inner join veiculo on compra.idveiculo = veiculo.id";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Compra listaCompra = new Compra(rs.getInt(1), rs.getString(2), rs.getString(3));
				listacompra.add(listaCompra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listacompra;
	}

}
