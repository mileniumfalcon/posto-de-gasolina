package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Funcionario;
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
    
    
    public static ArrayList<String> getFiliais() throws SQLException {
        
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

            if(linhasAfetadas > 0) {
                int idFuncionario = 0;
                ResultSet resultSet = comando.getGeneratedKeys();
                
                while(resultSet.next()){
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
}
