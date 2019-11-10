/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.BackOffice;
import br.com.mileniumfalcon.models.Diretor;
import br.com.mileniumfalcon.models.Funcionario;
import br.com.mileniumfalcon.models.GerenteVendas;
import br.com.mileniumfalcon.models.Rh;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erick
 */
public class UsuarioDAO {
    
    private DbConnectionDAO dbConnection = new DbConnectionDAO();
    
    public static Usuario pesquisaPorEmail(String email) {
        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT u.email, u.senha, f.tipo FROM "
                    + "Usuario u INNER JOIN Funcionario f ON f.IdFuncionario = u.IdFuncionario WHERE email LIKE ?");
            comando.setString(1, email);
            ResultSet rs = comando.executeQuery();

            Usuario usuario = null;

            while (rs.next()) {
                if (rs.getString("tipo").equals("Rh")) {
                    usuario = new Rh();
                } else if (rs.getString("tipo").equals("BackOffice")) {
                    usuario = new BackOffice();
                } else if (rs.getString("tipo").equals("Diretor")) {
                    usuario = new Diretor();
                } else if (rs.getString("tipo").equals("Vendedor")){
                    usuario = new Vendedor();
                } else {
                    usuario = new GerenteVendas();
                }

    
                usuario.setEmail(rs.getString("Email"));
                usuario.setSenha(rs.getString("Senha"));
            }

            DbConnectionDAO.closeConnection(connection);
            return usuario;

        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
}
