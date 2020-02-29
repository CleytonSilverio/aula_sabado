package br.edu.unifacear.telas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import br.edu.unifacear.DAO.CarroDAO;
import br.edu.unifacear.entidade.Carro;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.service.CarroService;

public class TelaCarros {

	public void mostrarTelaCarro() throws Exception{
			Scanner sc = new Scanner(System.in);
			System.out.println("-------------------------------------------------------------");
			System.out.println("Veiculos");
			for(;;) {
				System.out.println("1 - Cadastrar um veiculo");
				System.out.println("2 - Listar veiculos");
				System.out.println("3 - Excluir veiculo");
				System.out.println("4 - Alterar veiculo");
				System.out.println("5 - Tela principal");
				int opcao = sc.nextInt();
				if(opcao == 1) {
					Carro carro = new Carro();
					System.out.println("Digite o nome do carro: ");
					String modelo = sc.next();
					modelo += sc.nextLine();
					carro.setModelo(modelo);
					System.out.println("Digite a montadora: ");
					String montadora = sc.next();
					montadora += sc.nextLine();
					carro.setMontadora(montadora);
					System.out.println("Digite o valor: ");
					BigDecimal valor = sc.nextBigDecimal();
					carro.setValor(valor);
					
					try {
						new CarroService().inserir(carro);
					}catch (BusinessException e){
						System.out.println(e.getMessage());
					}
				}
				
				if(opcao == 2) {
					CarroDAO dao = new CarroDAO();
					List<Carro> carros = dao.listar();
					System.out.println("-------------------------------------------------------------");
					for (Carro c : carros) {
						System.out.println("Id do veiculo: " + c.getId());
						System.out.println("Modelo do veiculo: " + c.getModelo());
						System.out.println("Montadora: " + c.getMontadora());
						System.out.println("Valor: " + c.getValor());
						System.out.println("-------------------------------------------------------------");
					}
				}
				
				if(opcao == 3) {
					CarroDAO dao = new CarroDAO();
					List<Carro> carros = dao.listar();
					System.out.println("Digite o ID do carro que deseja excluir: ");
					int id = sc.nextInt();
					for (Carro c : carros) {
						if (c.getId() == id) {
							System.out.println("Veiculo: " + c.getModelo());
							dao.excluir(id);
							System.out.println("Veiculo excluido!");
						}
					}
				}
				
				if(opcao == 4) {
					CarroDAO dao = new CarroDAO();
					List<Carro> carros = dao.listar();
					System.out.println("Digite o id do carro que deseja atualizar: ");
					int id = sc.nextInt();
					for (Carro c : carros) {
						if (c.getId() == id) {
							System.out.println("Digite o nome do carro: ");
							String modelo = sc.next();
							modelo += sc.nextLine();
							c.setModelo(modelo);
							System.out.println("Digite a montadora: ");
							String montadora = sc.next();
							montadora += sc.nextLine();
							c.setMontadora(montadora);
							System.out.println("Digite o valor: ");
							BigDecimal valor = sc.nextBigDecimal();
							c.setValor(valor);
							
							try {
								new CarroDAO().alterar(id, c);
							}catch (BusinessException e){
								System.out.println(e.getMessage());
							}
						}
					}
				}
				
				if(opcao == 5) {
					break;
				}
			}
		}
		
	}
