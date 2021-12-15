/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.Item;
import model.Venda;

/**
 *
 * @author Arthur Carvalho
 */
public class RepositorioVenda {
    private Item[] itensVendidos;
    private int gerarcodigovenda;
    
    public RepositorioVenda() {
		itensVendidos = new Item[30]; // armazenamento
		gerarcodigovenda = 1;
	}
    
}
