package br.com.mileniumfalcon.models;

import java.util.Date;

/**
 *
 * @author erick
 */
public class PessoaJuridica extends Cliente{
    
    private String cnpj;
    private String telefone;
    
    public PessoaJuridica(int id, String nome, String endereco, String cep, String email,
                          String cnpj, String telefone) {
       super(id, nome, endereco, cep, email);
       
       this.cnpj = cnpj;
       this.telefone = telefone;
    }
    
    public PessoaJuridica(String nome, String endereco, String cep, String email,
                          String cnpj, String telefone) {
       super(nome, endereco, cep, email);
       
       this.cnpj = cnpj;
       this.telefone = telefone;
    }
    
    public PessoaJuridica() {}

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String getDocumento() {
        return cnpj;
    }
    
    @Override
    public void setDocumento(String cnpj) {
        this.cnpj = cnpj;
    }
}
