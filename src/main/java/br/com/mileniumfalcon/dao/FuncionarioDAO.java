package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.BackOffice;
import br.com.mileniumfalcon.models.Diretor;
import br.com.mileniumfalcon.models.FilialModel;
import br.com.mileniumfalcon.models.Funcionario;
import br.com.mileniumfalcon.models.Rh;
import br.com.mileniumfalcon.models.Vendedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class FuncionarioDAO {

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public static ArrayList<String> getFiliais() {

        ArrayList<String> filiais = new ArrayList<String>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT nome FROM Filial");
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                filiais.add(rs.getString("Nome"));
            }

        } catch (ClassNotFoundException ex) {
            filiais = null;
        } catch (SQLException ex) {
            System.out.println(ex);
            filiais = null;
        }

        DbConnectionDAO.closeConnection(connection);
        return filiais;
    }

    public static FilialModel getFilial(String nome) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFilial, Nome, Estado, Endereco, CEP FROM Filial WHERE Nome LIKE ?");
            comando.setString(1, nome);
            ResultSet rs = comando.executeQuery();

            FilialModel filial = new FilialModel();

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

    public static boolean salvar(Funcionario funcionario) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO Funcionario "
                    + "(Nome, Endereco, CEP, CPF, DataNascimento, DataInclusao, Tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEndereco());
            comando.setString(3, funcionario.getCep());
            comando.setString(4, funcionario.getCpf());
            comando.setDate(5, new Date(funcionario.getDataNascimento().getTime()));
            comando.setTimestamp(6, funcionario.getDataInclusao());
            comando.setString(7, funcionario.getClass().getSimpleName());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                int idFuncionario = 0;
                ResultSet resultSet = comando.getGeneratedKeys();

                while (resultSet.next()) {
                    idFuncionario = resultSet.getInt(1);
                }

                comando = connection.prepareStatement("INSERT INTO Usuario "
                        + "(IdFuncionario, Email, Senha) VALUES (?, ?, ?);");
                comando.setInt(1, idFuncionario);
                comando.setString(2, funcionario.getEmail());
                comando.setString(3, funcionario.getSenha());

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
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

    public static boolean salvarVendedor(Vendedor vendedor) {
        boolean salvou = FuncionarioDAO.salvar(vendedor);
        int id = getIdFuncionario(vendedor);
        boolean retorno = false;
        Connection connection = null;

        try {
            if (salvou) {
                connection = DbConnectionDAO.openConnection();
                PreparedStatement comando = connection.prepareStatement("INSERT INTO Vendedor "
                        + "(IdFuncionario, Gerente) VALUES (?, ?);");
                comando.setInt(1, id);
                comando.setBoolean(2, vendedor.isGerente());

                int linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    comando = connection.prepareStatement("INSERT INTO filial_vendedor "
                            + "(IdFilial, IdFuncionario) VALUES (?, ?);");
                    comando.setInt(1, vendedor.getFilial().getId());
                    comando.setInt(2, id);
                    linhasAfetadas = comando.executeUpdate();

                    if (linhasAfetadas > 0) {
                        retorno = true;
                    } else {
                        retorno = false;
                    }
                } else {
                    retorno = false;
                }
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

    public static Funcionario pesquisaPorCpf(String cpf) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFuncionario, Nome, Endereco, CEP, CPF, DataNascimento, DataInclusao, Tipo FROM Funcionario WHERE CPF LIKE ?");
            comando.setString(1, cpf);
            ResultSet rs = comando.executeQuery();

            Funcionario funcionario = null;

            while (rs.next()) {
                if (rs.getString("tipo").equals("Rh")) {
                    funcionario = new Rh();
                } else if (rs.getString("tipo").equals("BackOffice")) {
                    funcionario = new BackOffice();
                } else if (rs.getString("tipo").equals("Diretor")) {
                    funcionario = new Diretor();
                } else {
                    funcionario = new Vendedor();
                }

                funcionario.setId(rs.getInt("IdFuncionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setEndereco(rs.getString("Endereco"));
                funcionario.setCep(rs.getString("CEP"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setDataNascimento(rs.getDate("DataNascimento"));
                funcionario.setDataInclusao(rs.getTimestamp("DataInclusao"));
            }

            DbConnectionDAO.closeConnection(connection);
            return funcionario;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static Funcionario pesquisaPorId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT f.IdFuncionario, f.Nome, f.Endereco, " + ""
                    + "f.CEP, f.CPF, f.DataNascimento, f.DataInclusao, f.Tipo, u.Email, u.Senha " + 
                    "FROM Funcionario f INNER JOIN Usuario u ON f.IdFuncionario = u.IdFuncionario WHERE f.IdFuncionario = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Funcionario funcionario = null;

            while (rs.next()) {
                if (rs.getString("tipo").equals("Rh")) {
                    funcionario = new Rh();
                } else if (rs.getString("tipo").equals("BackOffice")) {
                    funcionario = new BackOffice();
                } else if (rs.getString("tipo").equals("Diretor")) {
                    funcionario = new Diretor();
                } else {
                    funcionario = new Vendedor();
                }

                funcionario.setId(rs.getInt("IdFuncionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setEndereco(rs.getString("Endereco"));
                funcionario.setCep(rs.getString("CEP"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setDataNascimento(rs.getDate("DataNascimento"));
                funcionario.setDataInclusao(rs.getTimestamp("DataInclusao"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setSenha(rs.getString("Senha"));
            }

            DbConnectionDAO.closeConnection(connection);
            return funcionario;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private static int getIdFuncionario(Funcionario funcionario) {
        int id = 0;
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFuncionario FROM Funcionario WHERE Cpf LIKE ?");
            comando.setString(1, funcionario.getCpf());
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                id = rs.getInt("IdFuncionario");
            }

            DbConnectionDAO.closeConnection(connection);
            return id;

        } catch (ClassNotFoundException ex) {
            return -1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
}
