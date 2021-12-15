package controller;

import db.RepositorioProduto;
import db.RepositorioVenda;

public class ControleVenda {
        private RepositorioVenda repoVenda;
	public boolean existirVenda(int codProduto) {
		return false;
	}
        public ControleVenda() {
		repoVenda = new RepositorioVenda();
	}
        
}
