
package br.com.mileniumfalcon.model.dao;

import br.com.mileniumfalcon.model.entity.ClienteEntity;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ClienteRepository extends IRepository
        implements IClienteRepository{

    @Override
    public int insertPessoaFisica(ClienteEntity cliente, Connection conexao) throws SQLException {
    StringBuilder sql = new StringBuilder();
        sql.append("insert into filial(Nome , CPF , DataNascimento, Telefone,Email,Endereco,Tipo)");
        sql.append(" values (?,?,?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        this.prepareStatement.setString(1, cliente.getNome());
        this.prepareStatement.setInt(2, cliente.getCpf());
        this.prepareStatement.setDate(3, cliente.getNascimento());
        this.prepareStatement.setString(4, cliente.getTelefone());
        this.prepareStatement.setString(5, cliente.getEmail());
        this.prepareStatement.setString(6, cliente.getEndereco());
        this.prepareStatement.setString(7, cliente.getTipo());
        this.prepareStatement.execute();

        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        // codigo que atribui o id para a entidade
        if (rs.next()) {
            return rs.getInt(1);
        }
        
        return 0;
    }

    @Override
    public boolean update(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQuantidade(Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteEntity> list(Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertPessoaJuridica(ClienteEntity cliente, Connection conexao) throws SQLException {
  StringBuilder sql = new StringBuilder();
        sql.append("insert into filial(Nome , CPF , DataNascimento, Telefone,Email,Endereco,Tipo)");
        sql.append(" values (?,?,?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        this.prepareStatement.setString(1, cliente.getNome());
        this.prepareStatement.setInt(2, cliente.getCpf());
        this.prepareStatement.setDate(3, cliente.getNascimento());
        this.prepareStatement.setString(4, cliente.getTelefone());
        this.prepareStatement.setString(5, cliente.getEmail());
        this.prepareStatement.setString(6, cliente.getEndereco());
        this.prepareStatement.setString(7, cliente.getTipo());
        this.prepareStatement.execute();

        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        // codigo que atribui o id para a entidade
        if (rs.next()) {
            return rs.getInt(1);
        }
        
        return 0;
    }


   

}


