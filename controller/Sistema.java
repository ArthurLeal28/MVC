package controller;

import sistema.model.Produto;
import sistema.view.ViewPrincipal;
import view.ViewProduto;

// Controle Principal
public class Sistema {
	private ViewProduto viewProduto;
	private ViewPrincipal viewPrincipal;
	private ControleProduto cProduto;
	private ControleVenda cVenda;

	private static Sistema instance;

	private Sistema() {
		cProduto = new ControleProduto();
		viewProduto = new ViewProduto();
		viewPrincipal = new ViewPrincipal();
	}

	// Singleton
	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}

	public void init() {
		cProduto.inserir(Produto.getInstance("Farinha", "Baiana", 2.50, 50));
                cProduto.inserir(Produto.getInstance("Feijao", "Supang", 3.50, 100));
                cProduto.inserir(Produto.getInstance("Beterraba", "oba", 2.00, 100));
                cProduto.inserir(Produto.getInstance("Arroz Gran aaaa", "Prato Fino", 22.50, 120));
		int opcao;

		do {
			opcao = viewPrincipal.menu();
			switch (opcao) {
			case 1:
				inserirProduto();
				break;

			case 2:

				break;

			case 3:
				alterarProduto();
				break;

			case 4:
				listarProdutos();
				break;

			case 5:
//				System.out.println("\nAte mais!\n");
				break;

			default:
//				System.out.println(
//						"\n\nNao foi possivel realizar a solicitacao.\n");
//				System.out.println("TENTE NOVAMENTE!");
			}
		} while (opcao != 5);
	}

	public void inserirProduto() {
		Produto p = viewProduto.lerProduto();
		// Sistema chama ao controle de Produto as regras de negocio
		boolean resposta = cProduto.inserir(p);

		if (resposta == true) {
			viewProduto.exibirMensagem("\nProduto cadastrado com sucesso!\n");
		} else {
			viewProduto.exibirMensagem("\nErro em cadastrar produto!\n");
		}
	}

	public void alterarProduto() {
		listarProdutos();
		int codigo = viewProduto.lerCodigoProdutoAlterado();
		Produto prod = cProduto.buscar(codigo); // busca produto pelo codigo
		if (prod != null) {
			Produto prodAlterado = viewProduto.alterar(prod);
			if (prodAlterado != null) { 
				// ==null eh pq a alteracao foi cancelada
				if (cProduto.alterar(prod))
					viewProduto.exibirMensagem(
							"\nProduto alterado com sucesso!\n");
				else
					viewProduto
							.exibirMensagem("\nErro em alterar produto!\n");
			}
		} else
			viewProduto.exibirMensagem("\nErro: codigo nao encontrado!\n");

	}

	public boolean excluirProduto(int codProduto) {
		// nao eh possivel excluir produto que ja tenha vendas realizadas
		if (!cVenda.existirVenda(codProduto))
			return cProduto.excluir(codProduto);
		else
			return false;
	}

	public void listarProdutos() {
		Produto[] lista = cProduto.listar();
		viewProduto.listar(lista);
	}
}