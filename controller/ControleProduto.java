package controller;

import db.RepositorioProduto;
import sistema.model.Produto;

// Regras de negocio de produto
public class ControleProduto {
	private RepositorioProduto repoProduto;

	public ControleProduto() {
		repoProduto = new RepositorioProduto();
	}

	public boolean inserir(Produto produto) {
		// nao pode ter mais de um produto com mesmo nome
		Produto p = repoProduto.buscar(produto.getNome());
		// se nao encontrou p recebe null
		if (p == null)
			return repoProduto.inserir(produto);
		else
			return false;
	}

	public boolean alterar(Produto produtoAlt) {
		// nao pode ter mais de um produto com mesmo nome
		Produto p = repoProduto.buscar(produtoAlt.getNome());
		// se nao encontrou p recebe null
		if (p == null)
			return repoProduto.alterar(produtoAlt);
		else
			return false;
	}

	public boolean excluir(int codProduto) {
		return repoProduto.excluir(codProduto);
	}

	public Produto buscar(int codigo) {
		return repoProduto.buscar(codigo);
	}

	public Produto[] listar() {
		return repoProduto.listar();
	}

}
