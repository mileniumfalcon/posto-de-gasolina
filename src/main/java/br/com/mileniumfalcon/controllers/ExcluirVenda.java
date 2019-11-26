package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ExcluirVenda", urlPatterns = {"/gerente-vendas/excluir-venda"})
public class ExcluirVenda extends HttpServlet {
    
    VendaDAO vDao = new VendaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        boolean excluiu;
        
        excluiu = vDao.excluir(id);
        if (excluiu) {
            request.setAttribute("canceladoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gerente-vendas.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-vendas-gerente.jsp");
            dispatcher.forward(request, response);
        }
    }

}
