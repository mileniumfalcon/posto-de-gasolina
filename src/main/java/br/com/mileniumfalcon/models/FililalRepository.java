package br.com.mileniumfalcon.models;

import br.com.mileniumfalcon.dao.IRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class FililalRepository extends IRepository implements FilialInterface{
    
    
    
      @Override
    public void insert(Filial filial, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into filial(endereco,estado,nome,dataCri)");
        sql.append(" values (?,?,?,date(now()))");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setString(1, filial.getEndereco());
        this.prepareStatement.setString(2, filial.getEstado());
        this.prepareStatement.setString(3, filial.getNome());
        
       
        
        this.prepareStatement.execute();
    }

    @Override
    public void update(Filial filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("metodo em construção"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateQuantidade(Filial filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Metodo em costrução"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet list(Filial filial, int idfilial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Metodo em costrução"); //To change body of generated methods, choose Tools | Templates.
    }

}
