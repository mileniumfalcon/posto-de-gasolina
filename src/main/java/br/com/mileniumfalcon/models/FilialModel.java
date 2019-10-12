package br.com.mileniumfalcon.models;
/**
 *
 * @author Victor
 */
public class FilialModel {
    int id;  
    String nome;
    String estado;
    String endereco;
    
 

    
    
    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    private int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
