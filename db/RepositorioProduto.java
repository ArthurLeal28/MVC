package db;

import model.Produto;

// Armazenamento de dados de produto
public class RepositorioProduto {
	private Produto[] produtos;
        private int numProdutos;
	private int proxCodigo;

	public RepositorioProduto() {
		produtos = new Produto[30]; // armazenamento
		proxCodigo = 1;
                numProdutos=0;
	}

	public boolean inserir(Produto produto) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i] == null) {
				produtos[i] = produto;
				produtos[i].setCodigo(proxCodigo);
				proxCodigo++;
                                numProdutos++;
				return true;
			}
		}
		return false;
	}

	public Produto buscar(String nome) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i] != null
					&& nome.equals(produtos[i].getNome())) {
				return new Produto(produtos[i]);
			}
		}
		return null;
	}

	public Produto buscar(int codigo) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i] != null && codigo == produtos[i].getCodigo() && produtos[i].getEstado()== 1 ) {
				return new Produto(produtos[i]);
			}
		}
		return null;
	}

	public boolean alterar(Produto produtoAlt) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i] != null
					&& produtoAlt.getCodigo() == produtos[i].getCodigo()) {
				produtos[i] = produtoAlt;
				return true;
			}
		}
		return false;
	}

	public boolean excluir(Produto p) {
		for (int indice = 0; indice < this.produtos.length; indice++) {
                        if (produtos[indice] != null) {     
                            if(produtos[indice].getCodigo() == p.getCodigo()){
                                produtos[indice] = null;
                                numProdutos--;
                                return true;
                                }
                            }
                        }
                
		return false;
	}
        public boolean excluirVenda(Produto p) {
		for (int indice = 0; indice < this.produtos.length; indice++) {
                        if (produtos[indice] != null) {     
                            if(produtos[indice].getCodigo() == p.getCodigo()){
                                produtos[indice].setEstado(0);
                                numProdutos--;
                                return true;
                                }
                            }
                        }
                
		return false;
	}

	public Produto[] ordemCadastro() {
            Produto[] cadastro = new Produto[produtos.length];
            Produto aux = null;
            int x =0;
            for (int indice = 0; indice < this.produtos.length; indice++) {
                if (produtos[indice] != null && produtos[indice].getEstado() == 1){
                    cadastro[x] = new Produto(produtos[indice]);
                    x++;
                }
            }
            for(int indice = 0; indice < cadastro.length; indice++){
               for(int c = 0; c < cadastro.length-1; c++){
                 if(cadastro[c] != null && cadastro[c+1] != null){
                  if(cadastro[c].getCodigo()>cadastro[c+1].getCodigo()){
                      aux = cadastro[c];
                      cadastro[c] = cadastro[c+1];
                      cadastro[c+1]=aux;
                      
                  }
                }
               }
            }
            return cadastro;
	}
        public Produto[] ordemAlf(){
                int x;
                x=numProdutos;

                Produto aux ;
                Produto []  vetord = new Produto[x];
                char n1;
                char n2;
                char n3;
                char n4;

                for(int l=0;l<x;l++)
                {
                    vetord[l]=new Produto(produtos[l]);
                }
               
                 for(int i=0;i<x;i++)
                 {
                     for(int c=0;c<x;c++)
                     {
                         n1 = vetord[c].getNome().charAt(0);
                         n2 = vetord[i].getNome().charAt(0);
                         n3 = vetord[c].getNome().charAt(1);
                         n4 = vetord[i].getNome().charAt(1);
                         if(n1>n2)
                         {
                             aux = vetord[c];
                             vetord[c]=vetord[i];
                             vetord[i]=aux;
                         }else if(n1==n2 && n3>n4){
                             aux = vetord[c];
                             vetord[c]=vetord[i];
                             vetord[i]=aux;
                         }
                     }
                 }
                return vetord;   
            }

}
