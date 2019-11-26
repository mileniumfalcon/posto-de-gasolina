package br.com.mileniumfalcon.models;

import br.com.mileniumfalcon.services.Services;

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

    public Filial(int id, String nome, String endereco, String cep, String estado) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.nome = nome;
        this.estado = estado;
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
