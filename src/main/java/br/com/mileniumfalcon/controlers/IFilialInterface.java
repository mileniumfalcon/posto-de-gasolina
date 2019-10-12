/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;

import br.com.mileniumfalcon.models.FilialModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface IFilialInterface {
    
    
    
    public void insert(FilialModel filial, Connection conexao) throws SQLException;
    
    public void update(FilialModel filial, Connection conexao) throws SQLException;
    
    public void updateQuantidade(FilialModel filial, Connection conexao) throws SQLException;
    
    public ResultSet list(FilialModel filial, int idfilial, Connection conexao) throws SQLException;
    
  
    
}
