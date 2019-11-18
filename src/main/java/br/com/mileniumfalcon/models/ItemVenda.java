
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.models;
/**
 *
 * @author Pablo de Oliveira
 */
public class ItemVenda {
    
    private Produto produto;
    private double quantidade;

    public ItemVenda(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public ItemVenda() {}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
//    public class ItemVenda {
//    private ArrayList<Produto> produtos;
//    private int idVenda;
//    private int Quantidade;
//
//    public ItemVenda() {
//    }
//
//     public ItemVenda(ArrayList<Produto> produtos, int Quantidade) {
//        this.produtos = produtos;
//        this.Quantidade = Quantidade;
//    }
//     
//    public ArrayList<Produto> getProdutos() {
//        return produtos;
//    }
//
//    public void setProdutos(ArrayList<Produto> produtos) {
//        this.produtos = produtos;
//    }
//
//    public int getIdVenda() {
//        return idVenda;
//    }
//
//    public void setIdVenda(int idVenda) {
//        this.idVenda = idVenda;
//    }
//
//    public int getQuantidade() {
//        return Quantidade;
//    }
//
//    public void setQuantidade(int Quantidade) {
//        this.Quantidade = Quantidade;
//    }
//
//   
//    
}
