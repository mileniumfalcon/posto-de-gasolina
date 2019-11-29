package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.services.RelatorioFilialService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Victor
 */
public class FilialDAO implements IDao{

    public Filial pesquisarFilialPorID(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFilial, Nome, Estado, Endereco, CEP FROM Filial WHERE IdFilial = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Filial filial = new Filial();

            while (rs.next()) {
                filial.setId(rs.getInt("IdFilial"));
                filial.setNome(rs.getString("Nome"));
                filial.setEstado(rs.getString("Estado"));
                filial.setEndereco(rs.getString("Endereco"));
                filial.setCep(rs.getString("Cep"));
            }

            DbConnectionDAO.closeConnection(connection);
            return filial;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public boolean salvar(Object object) {
        Filial filial = (Filial) object;
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("insert into Filial(Nome,Estado,Endereco,CEP)" + " values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

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

    public ArrayList<Filial> pesquisarFilial(String nome) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFilial, Nome, Endereco, Estado, CEP "
                    + "FROM Filial WHERE Nome LIKE ?");
            comando.setString(1, nome + "%");
            ResultSet rs = comando.executeQuery();

            ArrayList<Filial> filiais = new ArrayList<Filial>();

            while (rs.next()) {
                Filial filial = new Filial();
                filial.setId(rs.getInt("IdFilial"));
                filial.setNome(rs.getString("Nome"));
                filial.setEndereco(rs.getString("Endereco"));
                filial.setEstado(rs.getString("Estado"));
                filial.setCep(rs.getString("CEP"));
                
                filiais.add(filial);
            }

            DbConnectionDAO.closeConnection(connection);
            return filiais;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean editar(Object object) {
        Connection connection = null;
        Filial filial = (Filial) object;
        boolean editada;

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
            comando.setString(5, filial.getEndereco());
            comando.setInt(6, filial.getId());

            int linhasAfetadas = comando.executeUpdate();

            editada = linhasAfetadas > 0;

        } catch (ClassNotFoundException ex) {
            editada = false;
            System.out.println(ex);

        } catch (SQLException ex) {
            System.out.println(ex);
            editada = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return editada;

    }
    
    public boolean excluir (int id) {
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
    
    public int idFilialPorEmail(String email) {
        Connection connection = null;
        int id = 0;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT fi.IdFilial FROM filial_vendedor fi INNER JOIN Funcionario f "
                    + "ON fi.IdFuncionario = f.IdFuncionario INNER JOIN Usuario u "
                    + "ON f.IdFuncionario = u.IdFuncionario WHERE u.email LIKE ?");
            comando.setString(1, email);
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                id = rs.getInt("IdFilial");
            }

            DbConnectionDAO.closeConnection(connection);
            return id;

        } catch (ClassNotFoundException ex) {
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    public static ArrayList<RelatorioFilialService> consultarVendaTotaldeTodasFiliais(Date datainicio, Date datafim) {
        Connection connection = null;
        int id = 0;
        ArrayList<RelatorioFilialService> filiais = new ArrayList<RelatorioFilialService>();
        try {
            connection = DbConnectionDAO.openConnection();

            PreparedStatement comando = connection.prepareStatement(
                    "select f.nome, f.estado, sum(v.ValorTotal) from filial f  left JOIN Venda v on f.Idfilial = v.Idfilial and v.dataVenda between ? and ? group by f.nome;");

            comando.setDate(1, new java.sql.Date(datainicio.getTime()));
            comando.setDate(2, new java.sql.Date(datafim.getTime()));
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                RelatorioFilialService filial = new RelatorioFilialService();
                filial.setNome(rs.getString("Nome"));
                filial.setEstado(rs.getString("Estado"));
                filial.setValorTotalVendas(rs.getInt("sum(v.ValorTotal)"));
                filiais.add(filial);
            }

            DbConnectionDAO.closeConnection(connection);
            return filiais;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }
}
