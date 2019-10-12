package br.com.mileniumfalcon.dao;
import java.sql.PreparedStatement;


/**
 *
 * @author Victor
 */



public abstract class IRepository {
    protected PreparedStatement prepareStatement = null;
   
    
     public PreparedStatement generatePrepareStatement() {
        PreparedStatement preparedStatement = null;
        return preparedStatement = null;
    }
}


