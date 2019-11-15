package br.com.mileniumfalcon.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Venda {

    private int id;
    private double valorTotal;
    private Date dataVenda;
    private Cliente cliente;
    private Filial filial;
    ArrayList<ItemVenda> itens;

    public Venda(int id, double valorTotal, Date dataVenda, Cliente cliente,
            Filial filial, ArrayList<ItemVenda> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.filial = filial;
        this.itens = itens;
    }
    
    public Venda(double valorTotal, Date dataVenda, Cliente cliente,
            Filial filial, ArrayList<ItemVenda> itens) {
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.filial = filial;
        this.itens = itens;
    }
    
    public Venda() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
    
    public ArrayList<ItemVenda> getItens() {
        return itens;
    }
    
    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
}
