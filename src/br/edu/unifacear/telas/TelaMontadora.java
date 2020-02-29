package br.edu.unifacear.telas;

import java.util.List;
import java.util.Scanner;

import br.edu.unifacear.DAO.MontadoraDAO;
import br.edu.unifacear.entidade.Montadora;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.service.MontadoraService;

public class TelaMontadora {
	public void mostratTelaMontadora() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------------------");
		System.out.println("Montadoras");
		
		for(;;) {
			System.out.println("1 - Cadastrar montadoras");
			System.out.println("2 - Listar montadoras");
			System.out.println("3 - Tela principal");
			int opcao = sc.nextInt();
			
			if(opcao == 1) {
				Montadora montadora = new Montadora();
				System.out.println("Digite o nome da montadora: ");
				String nome = sc.nextLine();
				nome += sc.nextLine();
				montadora.setMontadora(nome);
				
				try {
					new MontadoraService().inserir(montadora);
				}catch (BusinessException e){
					System.out.println(e.getMessage());
				}
			}
			
			if (opcao == 2) {
				MontadoraDAO dao = new MontadoraDAO();
				List<Montadora> montadoras = dao.listar();
				System.out.println("-------------------------------------------------------------");
				for (Montadora c : montadoras) {
					System.out.println("Id da montadora: " + c.getId());
					System.out.println("Montadora: " + c.getMontadora());
					System.out.println("-------------------------------------------------------------");
				}
			}
			if (opcao == 3) {
				break;
			}
		}
		
	}

}
