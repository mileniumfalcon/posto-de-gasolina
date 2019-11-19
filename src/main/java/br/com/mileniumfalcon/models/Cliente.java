package br.com.mileniumfalcon.models;

/**
 *
 * @author erick
 */
public abstract class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String cep;
    private String email;

    public Cliente(int id, String nome, String endereco, String cep, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
    }
    
   public Cliente(String nome, String endereco, String cep, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
    }
   
   public Cliente() {}

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract String getDocumento();
    
    public abstract void setDocumento(String documento);
}
