package br.com.mileniumfalcon.models;

import java.util.Date;

/**
 *
 * @author erick
 */
public class PessoaFisica extends Cliente{
    
    private String cpf;
    private Date dataNascimento;
    
    public PessoaFisica(int id, String nome, String endereco, String cep, String email,
                        String cpf, Date dataNascimento) {
       super(id, nome, endereco, cep, email);
       
       this.cpf = cpf;
       this.dataNascimento = dataNascimento;
    }
    
    public PessoaFisica(String nome, String endereco, String cep, String email,
                        String cpf, Date dataNascimento) {
       super(nome, endereco, cep, email);
       
       this.cpf = cpf;
       this.dataNascimento = dataNascimento;
    }
    
    public PessoaFisica() {}
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String getDocumento() {
        return cpf;
    }
    
    @Override
    public void setDocumento(String cpf) {
        this.cpf = cpf;
    }
    
}
