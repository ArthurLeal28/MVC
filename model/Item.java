/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Arthur Carvalho
 */
public class Item {
    private Produto produto;
	private double preco;
	private int quantidade;

    private Item(Produto produto,double preco,int quantidade){
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Item(Item outro){
       if(outro!=null){
        this.preco =outro.preco;
        this.produto =outro.produto;
        this.quantidade = outro.quantidade;
       }
    }
    public static Item getInstance(Produto produto, double preco,int quantidade) {
		if (produto!=null && preco >= 0 && quantidade >= 0) {
			return new Item(produto,preco,quantidade);
		} else
			return null;
    }
}
