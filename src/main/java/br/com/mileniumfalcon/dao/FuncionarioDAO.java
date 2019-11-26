package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.BackOffice;
import br.com.mileniumfalcon.models.Diretor;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.Funcionario;
import br.com.mileniumfalcon.models.GerenteVendas;
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
public class FuncionarioDAO implements IDao{

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public ArrayList<String> getFiliais() {

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

    public Filial getFilial(String nome) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdFilial, Nome, Estado, Endereco, CEP FROM Filial WHERE Nome LIKE ?");
            comando.setString(1, nome);
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

    public Filial getFilialPorId(int id) {
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

    public boolean salvar(Object object) {
        Connection connection = null;
        boolean retorno = false;
        
        Funcionario funcionario = (Funcionario) object;

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

    public boolean salvarVendedor(Vendedor vendedor) {
        boolean salvou = salvar(vendedor);
        int id = getIdFuncionario(vendedor);
        boolean retorno = false;
        Connection connection = null;

        try {
            if (salvou) {
                connection = DbConnectionDAO.openConnection();
                PreparedStatement comando = connection.prepareStatement("INSERT INTO Vendedor "
                        + "(IdFuncionario, Gerente) VALUES (?, ?);");
                comando.setInt(1, id);

                if (vendedor.getClass().getSimpleName().equals("Vendedor")) {
                    comando.setBoolean(2, false);
                } else {
                    comando.setBoolean(2, true);
                }

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

    public boolean editar(Object object) {
        Connection connection = null;
        boolean retorno = false;
        
        Funcionario funcionario = (Funcionario) object;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE Funcionario "
                    + "SET Nome = ?, Endereco = ?, CEP = ?, CPF = ?, DataNascimento = ?, Tipo = ? "
                    + "WHERE IdFuncionario = ?", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getEndereco());
            comando.setString(3, funcionario.getCep());
            comando.setString(4, funcionario.getCpf());
            comando.setDate(5, new Date(funcionario.getDataNascimento().getTime()));
            comando.setString(6, funcionario.getClass().getSimpleName());
            comando.setInt(7, funcionario.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {

                comando = connection.prepareStatement("UPDATE Usuario SET "
                        + "Email = ?, Senha = ? "
                        + "WHERE IdFuncionario = ?");
                comando.setString(1, funcionario.getEmail());
                comando.setString(2, funcionario.getSenha());
                comando.setInt(3, funcionario.getId());

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

    public boolean editarVendedor(Vendedor vendedor) {
        int id = getIdFuncionario(vendedor);
        boolean isVendedor = isVendedor(id);
        boolean retorno = false;
        Connection connection = null;

        try {
            boolean editou = editar(vendedor);
            if (editou) {
                connection = DbConnectionDAO.openConnection();

                if (isVendedor) {
                    PreparedStatement comando = connection.prepareStatement("UPDATE Vendedor SET "
                            + "Gerente = ? WHERE IdFuncionario = ?");
                    if (vendedor.getClass().getSimpleName().equals("Vendedor")) {
                        comando.setBoolean(1, false);
                    } else {
                        comando.setBoolean(1, true);
                    }

                    comando.setInt(2, id);

                    int linhasAfetadas = comando.executeUpdate();

                    if (linhasAfetadas > 0) {
                        comando = connection.prepareStatement("UPDATE filial_vendedor SET "
                                + "IdFilial = ? WHERE IdFuncionario = ?");
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
                    PreparedStatement comando = connection.prepareStatement("INSERT INTO Vendedor "
                            + "(IdFuncionario, Gerente) VALUES (?, ?);");
                    comando.setInt(1, id);
                    
                    if (vendedor.getClass().getSimpleName().equals("Vendedor")) {
                        comando.setBoolean(2, false);
                    } else {
                        comando.setBoolean(2, true);
                    }

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

    public boolean excluir(int id) {

        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM Funcionario "
                    + "WHERE Funcionario.IdFuncionario = ?");
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

    public Funcionario pesquisaPorCpf(String cpf) {
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
                } else if (rs.getString("tipo").equals("Vendedor")) {
                    funcionario = new Vendedor();
                } else {
                    funcionario = new GerenteVendas();
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

    public Funcionario pesquisaPorId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT f.IdFuncionario, f.Nome, f.Endereco, " + ""
                    + "f.CEP, f.CPF, f.DataNascimento, f.DataInclusao, f.Tipo, u.Email, u.Senha "
                    + "FROM Funcionario f INNER JOIN Usuario u ON f.IdFuncionario = u.IdFuncionario WHERE f.IdFuncionario = ?");
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
                } else if (rs.getString("tipo").equals("Vendedor")){
                    funcionario = new Vendedor();
                } else {
                    funcionario = new GerenteVendas();
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
    
    public boolean buscaCpf(String cpf) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM Funcionario "
                    + "WHERE CPF = ?");
            comando.setString(1, cpf);

            ResultSet rs = comando.executeQuery();

             while (rs.next()) {
                if (rs.getString("CPF") != null) {
                    retorno = true;
                }
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

    private int getIdFuncionario(Funcionario funcionario) {
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

    private boolean isVendedor(int id) {
        int idFuncionario = 0;
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM Vendedor WHERE IdFuncionario = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                idFuncionario = rs.getInt("IdFuncionario");
            }

            DbConnectionDAO.closeConnection(connection);

            return idFuncionario != 0;

        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }

    }
}
