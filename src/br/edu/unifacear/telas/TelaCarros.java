package br.edu.unifacear.telas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import br.edu.unifacear.DAO.CarroDAO;
import br.edu.unifacear.entidade.Carro;

public class TelaCarros {

	public void mostrarTelaCarro() {
			Scanner sc = new Scanner(System.in);
			System.out.println("-------------------------------------------------------------");
			System.out.println("Veiculos");
			for(;;) {
				System.out.println("1 - Cadastrar um veiculo");
				System.out.println("2 - Listar veiculos");
				System.out.println("3 - Tela principal");
				int opcao = sc.nextInt();
				if(opcao == 1) {
					Carro carro = new Carro();
					System.out.println("Digite o ID do carro: ");
					int id = sc.nextInt();
					carro.setId(id);
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
					
					CarroDAO dao = new CarroDAO();
					dao.inserir(carro);
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
					break;
				}
			}
		}
		
	}
