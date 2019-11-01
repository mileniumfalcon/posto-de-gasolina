package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.PessoaFisica;
import br.com.mileniumfalcon.models.PessoaJuridica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Victor
 */


public class FilialDAO {

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public static boolean insertFilial(Filial filial) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("insert into filial(Nome,Estado,Endereco,CEP)" + " values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, filial.getNome());
            comando.setString(2, filial.getEstado());
            comando.setString(3, filial.getEndereco());
            comando.setString(4, filial.getCep());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }
        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }

    public static Filial pesquisarFilial(String nome) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFilial, Nome, Endereco, Estado, CEP "
                    + "FROM Filial WHERE Nome LIKE ?");
            comando.setString(1, "%" + nome + "%");
            ResultSet rs = comando.executeQuery();

            Filial filial = new Filial();

            while (rs.next()) {
                filial.setId(rs.getInt("IdFilial"));
                filial.setNome(rs.getString("Nome"));
                filial.setEndereco(rs.getString("Endereco"));
                filial.setEstado(rs.getString("Estado"));
                filial.setCep(rs.getString("CEP"));

            }

            DbConnectionDAO.closeConnection(connection);
            return filial;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean editarFilial(Filial filial) {
        Connection connection = null;
        boolean retorno;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE Filial "
                    + "SET Nome = ?, Endereco = ?, CEP = ?, Estado = ?, "
                    + "Endereco = ? "
                    + "WHERE IdFilial = ?");

            comando.setString(1, filial.getNome());
            comando.setString(2, filial.getEndereco());
            comando.setString(3, filial.getCep());
            comando.setString(4, filial.getEstado());
            comando.setString(4, filial.getEndereco());
            comando.setInt(6, filial.getId());

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

    public static boolean excluirFilial(int id) throws SQLException {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM Filial "
                    + "WHERE IdFilial = ?");
            comando.setInt(1, id);

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
}
