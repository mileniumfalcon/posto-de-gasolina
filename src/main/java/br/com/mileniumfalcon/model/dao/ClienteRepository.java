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
        implements IClienteRepository {

    @Override
    public int insertPessoaFisica(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente(Nome , CPF , DataNascimento, Telefone,Email,Endereco,Tipo)");
        sql.append(" values (?,?,?,?,?,?)");
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
        StringBuilder sql = new StringBuilder();
        sql.append("update cliente set Nome = ? , Estado = ? , Endereco = ?");
        sql.append(" where idCliente = ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setString(1, cliente.getNome());
        //this.prepareStatement.setString(2, cliente.getEstado());
        this.prepareStatement.setString(3, cliente.getEndereco());
        this.prepareStatement.setInt(4, cliente.getId());
        return this.prepareStatement.executeUpdate() > 0;
    }

    @Override
    public int getQuantidade(Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) from filial");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        return this.prepareStatement.executeQuery().getInt(1);
    }

    @Override
    public List<ClienteEntity> list(Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select idCliente , nome , estado , endereco from filial");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        ResultSet rs = this.prepareStatement.executeQuery();

        List<ClienteEntity> entitys = new ArrayList<>();
        while (rs.next()) {
            ClienteEntity entity = new ClienteEntity();
            entity.setId(rs.getInt(1));
            entity.setNome(rs.getString(2));
            entity.setCpf(rs.getInt(3));
            entity.setEndereco(rs.getString(4));
            entitys.add(entity);
        }

        return entitys;
    }

    @Override
    public boolean delete(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from Cliente");
        sql.append(" where idCliente = ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setInt(1, cliente.getId());
        return this.prepareStatement.executeUpdate() > 0;
    }

    @Override
    public int insertPessoaJuridica(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into filial(Nome , CNPJ , DataNascimento, Telefone,Email,Endereco,Tipo)");
        sql.append(" values (?,?,?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        this.prepareStatement.setString(1, cliente.getNome());
        this.prepareStatement.setInt(2, cliente.getCnpj());
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
