/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface FilialInterface {
    
    
    
    public void insert(Filial filial, Connection conexao) throws SQLException;
    
    public void update(Filial filial, Connection conexao) throws SQLException;
    
    public void updateQuantidade(Filial filial, Connection conexao) throws SQLException;
    
    public ResultSet list(Filial filial, int idfilial, Connection conexao) throws SQLException;
    
  
    
}
