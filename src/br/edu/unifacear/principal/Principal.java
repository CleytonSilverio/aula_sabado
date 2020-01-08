package br.edu.unifacear.principal;

import java.util.Scanner;

import br.edu.unifacear.telas.TelaCarros;
import br.edu.unifacear.telas.TelaMontadora;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1 - Veiculos");
			System.out.println("2 - Montadoras");
			System.out.println("3 - Clientes");
			System.out.println("4 - Sair");
			System.out.println("-------------------------------------------------------------");
			int opcao = sc.nextInt();
			
			
			if(opcao == 1) {
				new TelaCarros().mostrarTelaCarro();
			}
			
			if(opcao == 2) {
				new TelaMontadora().mostratTelaMontadora();
			}
			
			if(opcao == 3) {
				System.out.println("Tá pronto não");
			}
			
			if(opcao == 4 ) {
				break;
			}
			
			
		}

	}
}