package br.com.mileniumfalcon.services;

import java.text.DecimalFormat;

/**
 *
 * @author Victor
 */
public class RelatorioFilialService implements IRelatorioServices {

    private String nome;
    private String estado;
    private double valorTotalVendas;

    public RelatorioFilialService() {
    }

    public RelatorioFilialService(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.valorTotalVendas = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String getPorcentagem(double totalVenda) {
        DecimalFormat df = new DecimalFormat("0.00");
        double porcentagem = valorTotalVendas * 100 / totalVenda;
      String resultado = df.format(porcentagem) + "%";
        return resultado;
        
    }

    public void setEstado(String string) {
        this.estado = string;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setValorTotalVendas(int aInt) {
        this.valorTotalVendas = aInt;
    }

    public double getValorTotalVendas() {
        return this.valorTotalVendas;
    }

}
