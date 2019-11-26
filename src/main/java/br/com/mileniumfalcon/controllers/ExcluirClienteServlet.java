package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
@WebServlet(name = "ExcluirClienteServlet", urlPatterns = {"/vendedor/excluir-cliente"})
public class ExcluirClienteServlet extends HttpServlet {
    
    ClienteDAO cDao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        boolean excluiu;
        
        excluiu = cDao.excluir(id);
        if (excluiu) {
            request.setAttribute("excluidoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendedor.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-cliente.jsp");
            dispatcher.forward(request, response);
        }
  
    }
}
