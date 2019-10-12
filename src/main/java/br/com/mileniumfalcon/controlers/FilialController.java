package br.com.mileniumfalcon.controlers;

import br.com.mileniumfalcon.dao.Service;
import br.com.mileniumfalcon.models.FilialModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
public class FilialController extends Service implements IFilialInterface {

    @Inject
    private IFilialInterface filialInterface;
    
    
    @Override
    public void insert(FilialModel filial, Connection conexao) throws SQLException {
       
        
        try {
            if (filial != null) {
                getConnectOpen();
                filialInterface.insert(filial, conexao);
               
                getConnectClose();
            } 
          
        } catch (SQLException e) {
            getConnectClose();
          
        }
    }

    @Override
    public void update(FilialModel filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateQuantidade(FilialModel filial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet list(FilialModel filial, int idfilial, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
    
}
