package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Venda;
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
@WebServlet(name = "DetalhesVendaServlet", urlPatterns = {"/gerente-vendas/detalhes-venda"})
public class DetalhesVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/detalhes-venda-gerente.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Venda venda = VendaDAO.getVendaPorId(id);
        request.setAttribute("vendaAttr", venda);
        
        dispatcher.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
