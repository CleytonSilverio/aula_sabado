package br.edu.unifacear.telas;

import java.util.List;
import java.util.Scanner;

import br.edu.unifacear.DAO.ClienteDAO;
import br.edu.unifacear.entidade.Cliente;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.service.ClienteService;

public class TelaClientes {

	public void mostraClientes() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------------------");
		System.out.println("Clientes");

		for (;;) {
			System.out.println("1 - Cadastrar clientes");
			System.out.println("2 - Listar clientes");
			System.out.println("3 - Excluir cliente");
			System.out.println("4 - Atualizar Cliente");
			System.out.println("5 - Tela principal");
			int opcao = sc.nextInt();

			if (opcao == 1) {
				Cliente cliente = new Cliente();
				System.out.println("Digite o nome do cliente: ");
				String nome = sc.next();
				nome += sc.nextLine();
				cliente.setNome(nome);
				System.out.println("Digite o login do cliente: ");
				String login = sc.next();
				login += sc.nextLine();
				cliente.setLogin(login);
				System.out.println("Digite a senha do cliente: ");
				String senha = sc.next();
				senha += sc.nextLine();
				cliente.setSenha(senha);

				try {
					new ClienteService().inserir(cliente);
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
			}

			if (opcao == 2) {
				ClienteDAO dao = new ClienteDAO();
				List<Cliente> clientes = dao.listar();
				System.out.println("-------------------------------------------------------------");
				for (Cliente c : clientes) {
					System.out.println("Id do cliente: " + c.getId());
					System.out.println("Montadora: " + c.getNome());
					System.out.println("Login: " + c.getLogin());
					System.out.println("-------------------------------------------------------------");
				}
			}

			if (opcao == 3) {
				ClienteDAO dao = new ClienteDAO();
				List<Cliente> clientes = dao.listar();
				System.out.println("Digite o ID do cliente que deseja excluir: ");
				int id = sc.nextInt();
				for (Cliente c : clientes) {
					if (c.getId() == id) {
						dao.excluir(id);
						System.out.println("Cliente excluido!");
					}
				}
			}

			if (opcao == 4) {
				ClienteDAO dao = new ClienteDAO();
				List<Cliente> clientes = dao.listar();
				System.out.println("Digite o id do cliente que deseja atualizar: ");
				int id = sc.nextInt();
				for (Cliente c : clientes) {
					if (c.getId() == id) {
						System.out.println("Digite o nome do cliente: ");
						String nome = sc.next();
						nome += sc.nextLine();
						c.setNome(nome);
						System.out.println("Digite a login: ");
						String login = sc.next();
						login += sc.nextLine();
						c.setLogin(login);
						System.out.println("Digite a senha: ");
						String senha = sc.next();
						senha += sc.nextLine();
						c.setSenha(senha);

						try {
							new ClienteDAO().alterar(id, c);
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}

			if (opcao == 5) {
				break;
			}
		}

	}
}
