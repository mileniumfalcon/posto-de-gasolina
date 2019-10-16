package br.com.mileniumfalcon.model.dao;


import br.com.mileniumfalcon.model.entity.ClienteEntity;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IClienteRepository {
    
    
    public  int insertPessoaFisica(ClienteEntity cliente, Connection conexao) throws SQLException;
    
    public int insertPessoaJuridica(ClienteEntity cliente, Connection conexao) throws SQLException;
    
    public boolean update(ClienteEntity cliente, Connection conexao) throws SQLException;
    
    public int getQuantidade(Connection conexao) throws SQLException;
    
    public List<ClienteEntity> list(Connection conexao) throws SQLException;
    
    public boolean delete(ClienteEntity cliente, Connection conexao) throws SQLException;
    
}
