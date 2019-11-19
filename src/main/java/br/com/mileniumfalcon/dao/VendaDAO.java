package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.ItemVenda;
import br.com.mileniumfalcon.models.Venda;
import br.com.mileniumfalcon.services.RelatorioProdutoService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author erick
 */
public class VendaDAO {

    public static ArrayList<RelatorioProdutoService> dezMaisVendidosFilial(Date data, int id) {
        ArrayList<RelatorioProdutoService> produtos = new ArrayList<RelatorioProdutoService>();
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT p.nome, p.ValorUnitario, i.quantidade FROM Produto p INNER JOIN ItemVenda i "
                    + "ON p.IdProduto = i.IdProduto INNER JOIN Venda v ON "
                    + "i.IdVenda = v.IdVenda WHERE v.IdFilial = ? AND v.DataVenda = ?"
                    + "ORDER BY i.quantidade DESC LIMIT 10");
            comando.setInt(1, id);
            comando.setDate(2, new java.sql.Date(data.getTime()));

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                RelatorioProdutoService produto = new RelatorioProdutoService();

                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("ValorUnitario"));

                produtos.add(produto);
            }

            DbConnectionDAO.closeConnection(connection);
            return produtos;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static double totalVendidoFilial(Date data, int idFilial) {
        Connection connection = null;
        double total = 0;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT SUM(ValorTotal) AS ValorTotal FROM Venda WHERE IdFilial = ? AND DataVenda = ?");
            comando.setInt(1, idFilial);
            comando.setDate(2, new java.sql.Date(data.getTime()));

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("ValorTotal");
            }

            DbConnectionDAO.closeConnection(connection);
            return total;

        } catch (ClassNotFoundException ex) {
            return total;

        } catch (SQLException ex) {
            System.out.println(ex);
            return total;
        }
    }

    public static ArrayList<Venda> getVendasPorData(Date dataInicio, Date dataFinal, int idFilial) {
        Connection connection = null;
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT IdVenda, ValorTotal, DataVenda, IdCliente FROM Venda WHERE DataVenda BETWEEN ? AND ? AND IdFilial = ?");
            comando.setDate(1, new java.sql.Date(dataInicio.getTime()));
            comando.setDate(2, new java.sql.Date(dataFinal.getTime()));
            comando.setInt(3, idFilial);

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("IdVenda"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
                venda.setDataVenda(rs.getDate("DataVenda"));

                if (rs.getInt("IdCliente") != 0) {
                    Cliente cliente = ClienteDAO.pesquisarPorId(rs.getInt("IdCliente"));
                    venda.setCliente(cliente);
                }

                vendas.add(venda);
            }

            DbConnectionDAO.closeConnection(connection);
            return vendas;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static Venda getVendaPorId(int idVenda) {
        Connection connection = null;
        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT IdVenda, ValorTotal, DataVenda, IdCliente FROM Venda WHERE IdVenda = ?");
            comando.setInt(1, idVenda);

            ResultSet rs = comando.executeQuery();
            Venda venda = new Venda();

            while (rs.next()) {

                venda.setId(rs.getInt("IdVenda"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
                venda.setDataVenda(rs.getDate("DataVenda"));
                ArrayList<ItemVenda> itens = itensVendaPorId(rs.getInt("IdVenda"));
                venda.setItens(itens);

                if (rs.getInt("IdCliente") != 0) {
                    Cliente cliente = ClienteDAO.pesquisarPorId(rs.getInt("IdCliente"));
                    venda.setCliente(cliente);
                }
            }
            DbConnectionDAO.closeConnection(connection);
            return venda;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public static ArrayList<ItemVenda> itensVendaPorId(int idVenda) {
        Connection connection = null;
        ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement(
                    "SELECT IdProduto, IdVenda, Quantidade FROM ItemVenda WHERE IdVenda = ?");
            comando.setInt(1, idVenda);

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                ItemVenda item = new ItemVenda();

                item.setQuantidade(rs.getDouble("Quantidade"));
                item.setProduto(ProdutoDAO.pesquisarPorId(rs.getInt("IdProduto")));

                itens.add(item);
            }
            DbConnectionDAO.closeConnection(connection);
            return itens;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    public static boolean excluir(int id) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM ItemVenda WHERE IdVenda = ?");
            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                comando = connection.prepareStatement("DELETE FROM Venda "
                    + "WHERE IdVenda = ?");
                comando.setInt(1, id);

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

}