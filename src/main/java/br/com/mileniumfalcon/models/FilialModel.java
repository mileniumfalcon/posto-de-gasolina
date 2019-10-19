package br.com.mileniumfalcon.models;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Victor
 */
public class FilialModel {
    String nome;
    int id;  
    String estado;
    String endereco;
    String cep;
    DateTimeFormatter date;

    
    
    public String getNome() {
        return nome;
    }

    public DateTimeFormatter getDateCreate() {
        return date;
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
