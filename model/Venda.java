/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Arthur Carvalho
 */
public class Venda {
        private int codigo;
	private Date data;
        private double valorTotal;
        
    public Venda(Venda outro){
            if(outro != null){
                this.codigo = outro.codigo;
                this.data = outro.data;
                this.valorTotal = outro.valorTotal;
            }
        }
    private Venda(Date data )
    {
        this.data = data;
        this.valorTotal = 0.0;
    }
    public Venda getInstance(Date data)
    {
        if(data!=null)
        {
            return new Venda(data);
        }
        return null;
    }
}
