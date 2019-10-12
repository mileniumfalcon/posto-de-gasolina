package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick.ogurian
 */
@WebServlet(name = "CadastrarFuncionarioServlet", urlPatterns = {"/rh/cadastrar-funcionario"})
public class CadastrarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            ArrayList<String> filiais = FuncionarioDAO.getFiliais();
            for(String filial : filiais) {
                System.out.println(filial);
            }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp");
        dispatcher.forward(request, response);
        
        } catch (SQLException ex) {
            Logger.getLogger(RhServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
