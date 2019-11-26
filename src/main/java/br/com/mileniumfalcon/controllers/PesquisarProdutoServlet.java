package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Produto;
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
 * @author pablo.osantana
 */
@WebServlet(name = "PesquisarProdutoServlet", urlPatterns = {"/backoffice/pesquisa-de-produto"})
public class PesquisarProdutoServlet extends HttpServlet {
    
    ProdutoDAO pDao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-produto.jsp");
        String nome = request.getParameter("nome");

        ArrayList<Produto> produtos = pDao.pesquisarProduto(nome);

        if (!produtos.isEmpty()) {
            request.setAttribute("produtosAttr", produtos);
            
        } else {
            request.setAttribute("naoEncontradoAttr", true);
        }
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
