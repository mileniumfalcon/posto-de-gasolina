package br.com.mileniumfalcon.models;

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
    private Filial filial;


    public Produto() { }
    
    public Produto(int id, String nome, String tipoProduto, double qtdProduto, double vlrUnitario, Filial filial) {
        this.id = id;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
        this.filial = filial;
    }
    public Produto(String nome, String tipoProduto, double qtdProduto, double vlrUnitario, Filial filial) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
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

    public Filial getFilial() {
        return filial;
    }

    public void setFilialFilial() {
        this.filial = filial;
    }

    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

}
