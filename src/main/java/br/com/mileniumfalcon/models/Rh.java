package br.com.mileniumfalcon.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Rh extends Funcionario{
    
    public Rh (String email, String senha,
               int id, String nome, String endereco, String cpf,
               String cep, Date dataNascimento, Timestamp dataInclusao) {
        super(email, senha, id, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
    }
    
    public Rh (String email, String senha, 
               String nome, String endereco, String cpf,
               String cep, Date dataNascimento, Timestamp dataInclusao) {
        
        super(email, senha, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
    }
    
    public Rh () {}
    
}
