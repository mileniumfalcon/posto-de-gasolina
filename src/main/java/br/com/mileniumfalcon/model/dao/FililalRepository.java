package br.com.mileniumfalcon.model.dao;

import br.com.mileniumfalcon.controlers.IFilialInterface;
import br.com.mileniumfalcon.model.dao.IRepository;
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
public class FililalRepository extends IRepository implements IFilialRepository {

    @Override
    public int insert(FilialEntity filial, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into filial(Nome , Estado , Endereco)");
        sql.append(" values (?,?,?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        this.prepareStatement.setString(1, filial.getNome());
        this.prepareStatement.setString(2, filial.getEstado());
        this.prepareStatement.setString(3, filial.getEndereco());
        this.prepareStatement.execute();

        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        // codigo que atribui o id para a entidade
        if (rs.next()) {
            return rs.getInt(1);
        }
        
        return 0;
    }

    @Override
    public boolean update(FilialEntity filial, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("update filial set Nome = ? , Estado = ? , Endereco = ?");
        sql.append(" where idFilial = ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setString(1, filial.getNome());
        this.prepareStatement.setString(2, filial.getEstado());
        this.prepareStatement.setString(3, filial.getEndereco());
        this.prepareStatement.setInt(4, filial.getId());
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
    public List<FilialEntity> list(Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("select idFilial , nome , estado , endereco from filial");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        ResultSet rs = this.prepareStatement.executeQuery();

        List<FilialEntity> entitys = new ArrayList<>();
        while (rs.next()) {
            FilialEntity entity = new FilialEntity();
            entity.setId(rs.getInt(1));
            entity.setNome(rs.getString(2));
            entity.setEstado(rs.getString(3));
            entity.setEndereco(rs.getString(4));
            entitys.add(entity);
        }

        return entitys;
    }

    @Override
    public boolean delete(FilialEntity filial, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from filial");
        sql.append(" where idFilial = ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setInt(1, filial.getId());
        return this.prepareStatement.executeUpdate() > 0;
    }

}
