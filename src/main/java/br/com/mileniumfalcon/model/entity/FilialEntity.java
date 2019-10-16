package br.com.mileniumfalcon.model.entity;

import br.com.meleniumfalcon.model.models.FilialModel;

/**
 *
 * @author Victor
 */
public class FilialEntity {
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

    public int getId() {
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

    public FilialModel getModel() {
        FilialModel model = new FilialModel();
        model.setId(id);
        model.setNome(nome);
        model.setEstado(estado);
        model.setEndereco(endereco);
        return model;
    }

}
