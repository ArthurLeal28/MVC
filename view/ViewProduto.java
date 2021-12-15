package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Produto;

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
		System.out.println("Informe o nome do produto: "+produto.getNome());		
		String nome = scn.next();
		produto.setNome(nome);

		System.out.println("Informe a marca do produto: ");
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
        public int lerCodigoProdutoExcluir() {
		System.out.print("Código do Produto a ser excluido : ");
		int codigo = scn.nextInt();
		return codigo;
	}
       
        public int lerCodigoProduto() {
		System.out.print("Insira o codigo do produto que deseja : ");
                int codigo = scn.nextInt();
		return codigo;
	}
        public void odernarTabela(Produto produtos[]){
            int maiorNome = 0;
            int maiorMarca= 0;
            String nome = "Nome";
            String marca = "Marca";
            int nomeN = nome.length(); 
            int marcaN = marca.length();
                for(int x=0;x<produtos.length;x++){
                    if(produtos[x]!=null){
                        if(maiorNome<produtos[x].getNome().length()){
                            maiorNome=produtos[x].getNome().length(); 
                        }
                        if(maiorMarca<produtos[x].getMarca().length()){
                            maiorMarca = produtos[x].getMarca().length();
                        }
                    }
                }
                for(int x=0;x<produtos.length;x++){
                    if(produtos[x]!=null){
                        if(maiorNome>produtos[x].getNome().length()){
                            int diferenca = maiorNome-produtos[x].getNome().length();
                            for(int j=0;j<diferenca;j++){
                                produtos[x].setNome(produtos[x].getNome()+" ");
                            }
                        }
                        if(maiorMarca>produtos[x].getMarca().length()){
                            int diferenca = maiorMarca-produtos[x].getMarca().length();
                            for(int j=0;j<diferenca;j++){
                               produtos[x].setMarca( produtos[x].getMarca()+" ");
                            }
                        }
                    }
                }
                int diferencaN = maiorNome-nomeN;
                for(int j=0;j<diferencaN;j++){
                    nome = nome+" ";
                }
                int diferencaM = maiorMarca-marcaN;
                for(int j=0;j<diferencaM;j++){
                    marca = marca+" ";
                }
                gerarTabela(produtos,nome,marca);
        }
        
        public void gerarTabela(Produto produtos[],String nome,String marca){
           
           System.out.println("Codigo  | "+nome+" | "+marca+" | "+"Preco  | Quantidade  |");
           for(int indice=0;indice<produtos.length;indice++){
               if(produtos[indice]!=null){
               System.out.print(produtos[indice].getCodigo()+"       | "+produtos[indice].getNome()+" | "+produtos[indice].getMarca()+" |  ");
               System.out.printf("%.2f",produtos[indice].getPreco());
               System.out.print("  | "+produtos[indice].getQuantidade()+"\n");    
               }
           }
               
      }
}
