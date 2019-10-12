/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.ConnectionModel;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public abstract class config {
      private Connection connection;

    protected void getConnectOpen() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionModel.conectorDev();
        }
    }

    protected Connection getConnect() {
        return connection;
    }

    protected void getConnectClose() {
        try {
            if(connection != null || !connection.isClosed())
            connection.close();
        } catch (SQLException ex) {
        }
    }

  
}
