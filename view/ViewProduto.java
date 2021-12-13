package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.Sistema;
import sistema.model.Produto;

// Interacao com o usuario
public class ViewProduto {
	private Scanner scn = new Scanner(System.in);
	//private Sistema sis;

	public ViewProduto() {
		scn = new Scanner(System.in);
		//sis = Sistema.getInstance();
	}

	public Produto lerProduto() {
		System.out.println("\n\nCADASTRAR NOVO PRODUTO\n");
		// Produto produto = new Produto();

		System.out.print("Informe o nome do produto: ");
		String nome = scn.next();

		System.out.print("Informe a marca do produto: ");
		String marca = scn.next();

		System.out.print("Informe o preco do produto: R$ ");
		double preco = scn.nextDouble();

		System.out.print("Informe a quantidade em estoque do produto: ");
		int quantidade = scn.nextInt();

		Produto p = Produto.getInstance(nome, marca, preco, quantidade);

		return p;
		//boolean resposta = sis.inserir(p);
		
	}

	public Produto alterar(Produto produto) {
		// menu para saber o que sera alterado
//		System.out.print("Informe o nome do produto: ");		
//		String nome = scn.next();
		String nome = JOptionPane.showInputDialog("Informe o nome do produto",produto.getNome());
		produto.setNome(nome);

		System.out.print("Informe a marca do produto: ");
		String marca = scn.next();
		produto.setMarca(marca);
		
		System.out.print("Informe o preco do produto: R$ ");
		double preco = scn.nextDouble();
		produto.setPreco(preco);

		System.out.print("Informe a quantidade em estoque do produto: ");
		int quantidade = scn.nextInt();
		produto.setQuantidade(quantidade);
		
		return produto;
	}

	public void excluir() {

	}

	public void listar(Produto[] prods) {
		//Produto[] prods = sis.listar();
		//Produto[] prods = Sistema.getInstance().listar();
		System.out.println("\n\nListagem de Produto\n");
		System.out.println("COD\tNOME");
		for (int i = 0; i < prods.length; i++) {
			if (prods[i] != null) {
				System.out.println(
						prods[i].getCodigo() + "\t" + prods[i].getNome());
			}
		}
	}

	public void exibirMensagem(String msg) {
		System.out.println(msg);
		//JOptionPane.showMessageDialog(null, msg);
	}
	
	public int lerCodigoProdutoAlterado() {
		System.out.print("Código do Produto a ser alterado: ");
		int codigo = scn.nextInt();
		return codigo;
	}
}
