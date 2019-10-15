package br.com.meleniumfalcon.model.models;

import br.com.mileniumfalcon.model.entity.*;

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

    public void setId(int id) {
        this.id = id;
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

    public FilialEntity getEntity() {
        FilialEntity entity = new FilialEntity();
        entity.setId(id);
        entity.setNome(nome);
        entity.setEstado(estado);
        entity.setEndereco(endereco);
        return entity;
    }
}
