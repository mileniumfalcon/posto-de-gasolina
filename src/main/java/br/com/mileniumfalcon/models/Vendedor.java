package br.com.mileniumfalcon.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author erick
 */
public class Vendedor extends Funcionario {
    
    private Filial filial;
    private boolean gerente;
    
    public Vendedor(String email, String senha,
                    int id, String nome, String endereco, String cpf,
                    String cep, Date dataNascimento, Timestamp dataInclusao,
                    Filial filial, boolean gerente) {
        
        super(email, senha, id, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
        
        this.filial = filial;
        this.gerente = gerente;
    }
    
    public Vendedor(String email, String senha,
                    String nome, String endereco, String cpf,
                    String cep, Date dataNascimento, Timestamp dataInclusao,
                    Filial filial, boolean gerente) {
        
        super(email, senha, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
        
        this.filial = filial;
        this.gerente = gerente;
    }
    
    public Vendedor() {}

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }
}
