package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author erick
 */
@WebServlet(name = "ExcluirProdutoServlet", urlPatterns = {"/backoffice/excluir-produto"})
public class ExcluirProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        boolean excluiu;
        
        try {
            excluiu = ProdutoDAO.excluir(id);

            if (excluiu) {
                request.setAttribute("deletadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/backoffice.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-produto.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
