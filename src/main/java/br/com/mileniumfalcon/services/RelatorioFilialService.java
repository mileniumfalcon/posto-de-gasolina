package br.com.mileniumfalcon.services;

import java.text.DecimalFormat;

/**
 *
 * @author Victor
 */
public class RelatorioFilialService implements IRelatorioServices {

    private String nome;
    private String estado;
    private double faturamento;
    private int quantidadeVendas;

    public RelatorioFilialService() {
    }

    public RelatorioFilialService(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.faturamento = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return this.faturamento;
    }

    public void setValor(double valor) {
        this.faturamento = valor;
    }

    @Override
    public String getPorcentagem(double totalVenda) {
        DecimalFormat df = new DecimalFormat("0.00");
        double porcentagem = (faturamento * quantidadeVendas) * 100 / totalVenda;

        return df.format(porcentagem) + "%";
    }

}
