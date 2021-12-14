package db;

import model.Produto;

// Armazenamento de dados de produto
public class RepositorioProduto {
	private Produto[] produtos;
	private int proxCodigo;

	public RepositorioProduto() {
		produtos = new Produto[30]; // armazenamento
		proxCodigo = 1;
	}

	public boolean inserir(Produto produto) {
		for (int i = 0; i < this.produtos.length; i++) {
			if (this.produtos[i] == null) {
				produtos[i] = produto;
				produtos[i].setCodigo(proxCodigo);
				proxCodigo++;
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
			if (this.produtos[i] != null && codigo == produtos[i].getCodigo()) {
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

	public boolean excluir(int codProduto) {
		return false;
	}

	public Produto[] listar() {
		// Produto[] aux = new Produto[30];
		return produtos;
	}

}
