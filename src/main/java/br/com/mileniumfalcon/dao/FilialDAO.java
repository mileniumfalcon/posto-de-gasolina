package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Filial;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class FililalDAO {

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public static boolean insertFilial(Filial filial) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO Cliente "
                    + "(Nome, Endereco, CEP, CPF, DataNascimento, Email, Tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            comando.setString(1, filial.getNome());
            comando.setString(2, filial.getEndereco());
            comando.setString(3, filial.getCep());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }
        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }

    public void update(Filial filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("metodo em construção"); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateQuantidade(Filial filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Metodo em costrução"); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet list(Filial filial, int idfilial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Metodo em costrução"); //To change body of generated methods, choose Tools | Templates.
    }

}
