package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "FormularioRelatorioBackOffice", urlPatterns = {"/backoffice/visualizar-vendas"})
public class FormularioRelatorioBackOffice extends HttpServlet {
    
    FuncionarioDAO fDao = new FuncionarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/visualizar-vendas.jsp");
        ArrayList<String> filiais = fDao.getFiliais();
            
        request.setAttribute("filiaisAttr", filiais);
        
        dispatcher.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
