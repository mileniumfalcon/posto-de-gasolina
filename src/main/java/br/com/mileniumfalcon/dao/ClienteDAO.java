package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.PessoaFisica;
import br.com.mileniumfalcon.models.PessoaJuridica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erick
 */
public class ClienteDAO {

    private DbConnectionDAO dbConnection = new DbConnectionDAO();

    public static boolean salvarFisico(PessoaFisica cliente) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO Cliente "
                    + "(Nome, Endereco, CEP, CPF, DataNascimento, Email, Tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEndereco());
            comando.setString(3, cliente.getCep());
            comando.setString(4, cliente.getCpf());
            comando.setDate(5, new Date(cliente.getDataNascimento().getTime()));
            comando.setString(6, cliente.getEmail());
            comando.setString(7, "Pessoa Fisica");

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

    public static boolean salvarJuridico(PessoaJuridica cliente) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO Cliente "
                    + "(Nome, Endereco, CEP, CNPJ, Telefone, Email, Tipo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEndereco());
            comando.setString(3, cliente.getCep());
            comando.setString(4, cliente.getCnpj());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getEmail());
            comando.setString(7, "Pessoa Juridica");

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

    public static Cliente pesquisarPorDocumento(String documento) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdCliente, Nome, CPF, CNPJ "
                    + "FROM Cliente WHERE CPF LIKE ? OR CNPJ LIKE ?");
            comando.setString(1, documento);
            comando.setString(2, documento);
            ResultSet rs = comando.executeQuery();

            Cliente cliente = new Cliente();

            while (rs.next()) {

                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));

                if (rs.getString("CPF") != null) {
                    cliente.setDocumento(rs.getString("CPF"));
                } else {
                    cliente.setDocumento(rs.getString("CNPJ"));
                }
            }

            DbConnectionDAO.closeConnection(connection);
            return cliente;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public static Cliente pesquisarPorId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdCliente, Nome, CPF, CNPJ, Endereco, Email "
                    + "FROM Cliente WHERE IdCliente = ?");
            comando.setInt(1, id);
            
            ResultSet rs = comando.executeQuery();

            Cliente cliente = new Cliente();

            while (rs.next()) {
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setEmail(rs.getString("Email"));

                if (rs.getString("CPF") != null) {
                    cliente.setDocumento(rs.getString("CPF"));
                } else {
                    cliente.setDocumento(rs.getString("CNPJ"));
                }
            }

            DbConnectionDAO.closeConnection(connection);
            return cliente;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static PessoaFisica pesquisarFisicoPorId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdCliente, Nome, Endereco, CPF, CEP, "
                    + "DataNascimento, Email "
                    + "FROM Cliente WHERE IdCliente = ?");
            comando.setInt(1, id);

            ResultSet rs = comando.executeQuery();

            PessoaFisica cliente = new PessoaFisica();

            while (rs.next()) {
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setCep(rs.getString("CEP"));
                cliente.setDataNascimento(rs.getDate("DataNascimento"));
                cliente.setEmail(rs.getString("Email"));
            }

            DbConnectionDAO.closeConnection(connection);
            return cliente;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static PessoaJuridica pesquisarJuridicoPorId(int id) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT IdCliente, Nome, Endereco, CNPJ, CEP, "
                    + "Telefone, Email "
                    + "FROM Cliente WHERE IdCliente = ?");
            comando.setInt(1, id);

            ResultSet rs = comando.executeQuery();

            PessoaJuridica cliente = new PessoaJuridica();

            while (rs.next()) {
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setEndereco(rs.getString("Endereco"));
                cliente.setCnpj(rs.getString("CNPJ"));
                cliente.setCep(rs.getString("CEP"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEmail(rs.getString("Email"));
            }

            DbConnectionDAO.closeConnection(connection);
            return cliente;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean editarFisico(PessoaFisica cliente) {
        Connection connection = null;
        boolean retorno;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE Cliente "
                    + "SET Nome = ?, Endereco = ?, CEP = ?, CPF = ?, "
                    + "DataNascimento = ?, Email = ? "
                    + "WHERE IdCliente = ?");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEndereco());
            comando.setString(3, cliente.getCep());
            comando.setString(4, cliente.getCpf());
            comando.setDate(5, new Date(cliente.getDataNascimento().getTime()));
            comando.setString(6, cliente.getEmail());
            comando.setInt(7, cliente.getId());
            
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
    
    public static boolean editarJuridico(PessoaJuridica cliente) {
        Connection connection = null;
        boolean retorno;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE Cliente "
                    + "SET Nome = ?, Endereco = ?, CEP = ?, CNPJ = ?, "
                    + "Telefone = ?, Email = ? "
                    + "WHERE IdCliente = ?");

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEndereco());
            comando.setString(3, cliente.getCep());
            comando.setString(4, cliente.getCnpj());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getEmail());
            comando.setInt(7, cliente.getId());
            
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
    
    public static boolean excluir(int id) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM Cliente "
                    + "WHERE IdCliente = ?");
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
