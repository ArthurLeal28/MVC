package sistema.view;

import java.util.Scanner;


public class ViewPrincipal {
	public int menu() {
		Scanner scn = new Scanner(System.in);
		// UIProduto uiProduto = new UIProduto();
		int opcao;
		
		System.out.println("\n\nCENTRAL DE CONTROLE\n");
		System.out.println(" 1 - Inserir produtos");
		System.out.println(" 2 - Excluir produtos");
		System.out.println(" 3 - Alterar dados de um produto");
		System.out.println(" 4 - Gerar as listagens");
		System.out.println(" 5 - Sair do sistema\n");
		System.out.print("Insira o codigo da acao que deseja executar: ");

		return scn.nextInt();

		
	}
}
