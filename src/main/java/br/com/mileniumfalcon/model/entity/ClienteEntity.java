package br.com.mileniumfalcon.model.entity;


import br.com.meleniumfalcon.model.models.ClienteModel;
import java.sql.Date;

/**
 *
 * @author Victor
 */
public class ClienteEntity {
     int id;
  String nome;
 int cpf;
 int cnpj;
 Date nascimento;
 String telefone;
 String email;
 String endereco;
 String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String varchar) {
        this.tipo = varchar;
    }
    
        public ClienteModel getModel() {
        ClienteModel model = new ClienteModel();
        model.setId(id);
        model.setNome(nome);
        model.setCpf(cpf);
        model.setCnpj(cnpj);
        model.setNascimento(nascimento);
        model.setTelefone(telefone);
        model.setEmail(email);
        model.setEndereco(endereco);
        model.setTipo(tipo);
        return model;
    }

    
}
