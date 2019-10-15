/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.model.dao;
import java.sql.*;

/**
 *
 * @author Victor
 */


public class ConnectionModel {

    public static Connection conectorProd() {
        String driver = "";

        //prod
        String url = "";
        String user = "";
        String password = "";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static Connection conectorDev() {
        String driver = "com.mysql.jdbc.Driver";
        String server = "localhost:3306";
        String database = "postostades";
        //dev
        String url = "jdbc:mysql://" + server + "/" + database + "?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}


