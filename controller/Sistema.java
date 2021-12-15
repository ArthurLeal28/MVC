package controller;

import model.Produto;
import view.ViewPrincipal;
import view.ViewProduto;
import view.ViewVenda;

// Controle Principal
public class Sistema {
	private ViewProduto viewProduto;
	private ViewPrincipal viewPrincipal;
	private ControleProduto cProduto;
	private ControleVenda cVenda;
        private ViewVenda viewVenda;

	private static Sistema instance;

	private Sistema() {
		cProduto = new ControleProduto();
                cVenda = new ControleVenda();
		viewProduto = new ViewProduto();
		viewPrincipal = new ViewPrincipal();
                viewVenda = new ViewVenda();
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
                cProduto.inserir(Produto.getInstance("Arroz Gran", "Prato Fino", 22.50, 120));
		int opcao;

		do {
			opcao = viewPrincipal.menu();
                        
			switch (opcao) {
			case 1:
				inserirProduto();
				break;

			case 2:
                                excluir();
				break;

			case 3:
				alterarProduto();
				break;

			case 4:
				listarProdutos();
				break;

			case 5:
                                viewPrincipal.exibirMensagem("\nAte mais!\n");
//				
				break;

			default:
                                viewPrincipal.exibirMensagem("\n\nNao foi possivel realizar a solicitacao.\n");
//                              
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
        public void excluir() {
            int codigo = viewProduto.lerCodigoProdutoExcluir();
            if(cVenda.existirVenda(codigo)){
                boolean resposta = cProduto.excluirVenda(codigo);
                if(resposta)
                    viewProduto.exibirMensagem("\nProduto excluido!\n");
                else
                     viewProduto.exibirMensagem("\nErro em excluir!\n");
            }else{
                boolean resposta = cProduto.excluir(codigo);
                if(resposta)
                    viewProduto.exibirMensagem("\nProduto excluido!\n");
                else
                     viewProduto.exibirMensagem("\nErro em excluir!\n");
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
					viewProduto.exibirMensagem("\nProduto alterado com sucesso!\n");
				else
					viewProduto.exibirMensagem("\nErro em alterar produto!\n");
			}
		} else
			viewProduto.exibirMensagem("\nErro: codigo nao encontrado!\n");

	}

	

	public void listarProdutos() {
                Produto aux2[];
                Produto aux[];
               int opcao;
            do {
                opcao = viewPrincipal.menuListar();
                switch (opcao) {
		case 1:
                        int codigo = viewProduto.lerCodigoProduto();
                        Produto aux1[] = new Produto[1];
                        aux1[0] = cProduto.buscar(codigo);
                        if(aux1[0]!=null){
                            viewProduto.odernarTabela(aux1);
                        }else
                           viewProduto.exibirMensagem("Produto não existe");
			
                        break;
                case 2:
                        aux2 = cProduto.buscarOrdemCadastro();
                        viewProduto.odernarTabela(aux2);
                        break;
                case 3:
                        aux2 = cProduto.ordenar();
                        viewProduto.odernarTabela(aux2);
                        break;
		 
		case 4:
			viewPrincipal.exibirMensagem("\nAte mais!\n");
			break;

		default:
			viewPrincipal.exibirMensagem("\nCodigo inserido eh invalido! Retornando para o menu...\n");
			
		}
            } while (opcao!= 4);
		
	}
}