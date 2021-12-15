package controller;

import db.RepositorioProduto;
import model.Produto;

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
                Produto p = repoProduto.buscar(codProduto);
                if(p != null)
                    return repoProduto.excluir(p);  
                else 
                    return false;
	}
        public boolean excluirVenda(int codProduto) {
                Produto p = repoProduto.buscar(codProduto);
                if(p != null)
                    return repoProduto.excluirVenda(p);  
                else 
                    return false;
	}

	public Produto buscar(int codigo) {
		return repoProduto.buscar(codigo);
	}
        public Produto[] buscarOrdemCadastro(){
            return repoProduto.ordemCadastro();
        }
        public Produto[] ordenar(){
            return repoProduto.ordemAlf();
        }
	

}
