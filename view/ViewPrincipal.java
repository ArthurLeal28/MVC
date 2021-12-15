package view;

import java.util.Scanner;


public class ViewPrincipal {
        Scanner scn = new Scanner(System.in);
	public int menu() {
		
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
        public int menuListar(){
                System.out.println("\n\nCENTRAL DE CONTROLE - Listagem\n");
		System.out.println(" 1 - Detalhar um produto");
		System.out.println(" 2 - Exibir todos os produtos (ORDEM DE CADASTRO)");
		System.out.println(" 3 - Exibir todos os produtos (ORDEM ALFABETICA)");
		System.out.println(" 4 - Sair do sistema\n");
		System.out.print("Insira o codigo da acao que deseja executar: ");
                return scn.nextInt();
        }
}
