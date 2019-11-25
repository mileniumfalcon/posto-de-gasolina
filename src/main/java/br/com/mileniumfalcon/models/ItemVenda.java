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
    
    public boolean qtdPermitida(){return this.quantidade < this.produto.getQtdProduto();}
    public double vlrTotalItem(){return this.produto.getVlrUnitario()*this.quantidade;}
}
