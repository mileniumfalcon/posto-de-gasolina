/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Pablo de Oliveira
 */
public class Venda {
   private int idVenda;
   private double valorTotal;
   private Timestamp dataVenda;
   private int idCliente;
   private int idFilial;

    public Venda() {
    }

    public Venda(double valorTotal, Timestamp dataVenda, int idCliente, int idFilial) {
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idFilial = idFilial;
    }

    public Venda(double valorTotal, Timestamp dataVenda, int idFilial) {
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.idFilial = idFilial;
    }

    public Venda(int IdVenda, double ValorTotal, Date DataVenda, int IdCliente, int IdFilial) {
        this.idVenda = idVenda;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idFilial = idFilial;
    }

    public int getIdVenda() {
        return idVenda;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Timestamp dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }
    
}
