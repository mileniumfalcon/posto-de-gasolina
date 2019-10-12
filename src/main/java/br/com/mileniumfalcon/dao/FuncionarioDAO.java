package br.com.mileniumfalcon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
