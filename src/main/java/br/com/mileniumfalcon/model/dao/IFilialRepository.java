/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.model.dao;

import br.com.meleniumfalcon.model.models.FilialModel;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IFilialRepository {
    
    public int insert(FilialEntity filial, Connection conexao) throws SQLException;
    
    public boolean update(FilialEntity filial, Connection conexao) throws SQLException;
    
    public int getQuantidade(Connection conexao) throws SQLException;
    
    public List<FilialEntity> list(Connection conexao) throws SQLException;
    
    public boolean delete(FilialEntity filial, Connection conexao) throws SQLException;
    
}
