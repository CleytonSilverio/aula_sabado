package br.edu.unifacear.telas;

import java.util.List;
import java.util.Scanner;

import br.edu.unifacear.DAO.ClienteDAO;
import br.edu.unifacear.entidade.Cliente;
import br.edu.unifacear.entidade.Compra;
import br.edu.unifacear.exception.BusinessException;
import br.edu.unifacear.service.CompraService;

public class TelaCompra {
	
	public void mostrarTelaCompra() throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			
			System.out.println("1 - Comprar");
			System.out.println("2 - Ver compras efetuadas");
			System.out.println("3 - Sair");
			int opcao = sc.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite o id do cliente: ");
				int idcli = sc.nextInt();
				System.out.println("Digite o id do veiculo: ");
				int idvei = sc.nextInt();
				
				try {
					new CompraService().comprar(idcli, idvei);
				}catch (BusinessException e){
					System.out.println(e.getMessage());
				}
			}
			
			if (opcao == 2) {
				ClienteDAO dao = new ClienteDAO();
				List<Compra> compras = dao.listarCompras();
				System.out.println("-------------------------------------------------------------");
				for (Compra c : compras) {
					System.out.println("Id da venda: " + c.getId());
					System.out.println("Cliente: " + c.getIdcliente());
					System.out.println("Carro: " + c.getIdveiculo());
					System.out.println("-------------------------------------------------------------");
				}
			}
			
			if(opcao == 3) {
				break;
			}
		}
		
		
	}

}
