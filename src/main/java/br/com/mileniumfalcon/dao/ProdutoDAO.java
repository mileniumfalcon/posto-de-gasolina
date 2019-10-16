/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.ProdutoModel;
import com.mysql.cj.util.TimeUtil;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import br.com.mileniumfalcon.dao.DbConnectionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.NumberFormat;

/**
 *
 * @author pablo.santana
 */
public class ProdutoDAO {

    public static boolean salvar(ProdutoModel produto) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement enviar = connection.prepareStatement("INSERT INTO Produto "
                    + "(Nome, TipoProduto, QntEstoque, ValorUnitario) "
                    + "VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            enviar.setString(1, produto.getNome());
            enviar.setString(2, produto.getTipoProduto());
            enviar.setDouble(3, produto.getQtdProduto());
            enviar.setDouble(4, produto.getVlrUnitario());
           // enviar.setInt(5, produto.getIdFilial());

            int linhasAfetadas = enviar.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            } else {
                retorno = false;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }
    public static ProdutoModel pesquisarProduto (String nome){
        Connection connection = null;
        
        try{
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM Funcionario WHERE Nome LIKE ?");
            comando.setString(1, nome);
            ResultSet rs = comando.executeQuery();
            ProdutoModel produto = null;
            while(rs.next()){
             produto.setIdProduto(rs.getInt("idProduto"));
             produto.setNome(rs.getString("Nome"));
             produto.setTipoProduto(rs.getString("TipoProduto"));
             produto.setQtdProduto(rs.getDouble("QntEstoque"));
             produto.setVlrUnitario(rs.getDouble("ValorUnitario"));
            }
             DbConnectionDAO.closeConnection(connection);
             return produto;
            
        }catch(ClassNotFoundException ex){
            return null;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    public static void deletarProduto (String nome)throws SQLException{
       Connection connection = null;
       try{
           connection = DbConnectionDAO.openConnection();
           PreparedStatement comando = connection.prepareStatement("delete from Produto where nome = ?");
           comando.setString(1, nome);
       }catch(ClassNotFoundException ex){
           
       }catch(SQLException ex){
           
       }catch(Exception e){
           System.out.println(e);
       }
       
    }

   
}
