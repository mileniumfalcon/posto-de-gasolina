package br.com.mileniumfalcon.models;

import java.util.ArrayList;

/**
 *
 * @author pablo.osantana
 */
public class Produto {

    private int id;
    private String nome;
    private String tipo;
    private double qtdProduto;
    private double vlrUnitario;
    private Filial filial;


    public Produto() { }
    
    public Produto(int id, String nome, String tipo, double qtdProduto, double vlrUnitario,
                   Filial filial) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.filial = filial;
    }
    public Produto(String nome, String tipo, double qtdProduto, double vlrUnitario,
            Filial filial) {
        this.nome = nome;
        this.tipo = tipo;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.filial = filial;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipoProduto(String tipo) {
        this.tipo = tipo;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

}
