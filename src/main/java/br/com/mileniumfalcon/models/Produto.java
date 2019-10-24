package br.com.mileniumfalcon.models;

import java.util.ArrayList;

/**
 *
 * @author pablo.osantana
 */
public class Produto {

    private int id;
    private String nome;
    private String tipoProduto;
    private double qtdProduto;
    private double vlrUnitario;
    private ArrayList<Filial> filiais;


    public Produto() { }
    
    public Produto(int id, String nome, String tipoProduto, double qtdProduto, double vlrUnitario,
                   ArrayList<Filial> filiais) {
        this.id = id;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.filiais = filiais;
    }
    public Produto(String nome, String tipoProduto, double qtdProduto, double vlrUnitario,
            ArrayList<Filial> filiais) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.filiais = filiais;
    }


    public int getId() {
        return id;
    }

    public void setId(int idProduto) {
        this.id = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public ArrayList<Filial> getFiliais() {
        return filiais;
    }

    public void setFilialFilial(ArrayList<Filial> filiais) {
        this.filiais = filiais;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

}
