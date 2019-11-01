package br.com.mileniumfalcon.models;

/**
 *
 * @author Victor
 */
public class Filial {

    String nome;
    int id;
    String estado;
    String endereco;
    String cep;

    public Filial(String nome, String estado, String endereco, String cep) {
        this.cep = cep;
        this.endereco = endereco;
        this.nome = nome;
        this.estado = estado;
    }

    public Filial() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}

