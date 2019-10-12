package br.com.mileniumfalcon.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Funcionario extends Usuario{
    private int id;
    private String nome;
    private String endereco;
    private String cpf;
    private Date dataNascimento;
    private Timestamp dataInclusao;
    
    public Funcionario(String email, String senha,
                       int id, String nome, String endereco, String cpf,
                       Date dataNascimento, Timestamp dataInclusao) {
        
        super(email, senha);
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
    }
    
    public Funcionario(String email, String senha, 
                       String nome, String endereco, String cpf,
                       Date dataNascimento, Timestamp dataInclusao) {
        
        super(email, senha);
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Timestamp dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
    
    
}
