/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;

import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author pablo.osantana
 */
@WebServlet(name = "PesquisarProdutoServlet", urlPatterns = {"/backoffice/pesquisar-produto"})
public class PesquisarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-produto.jsp");
        String nome = request.getParameter("nome");
        
        ProdutoModel produto = ProdutoDAO.pesquisarProduto(nome);
        
        if (produto != null) {
            request.setAttribute("idAttr", Integer.toString(produto.getIdProduto()));
            request.setAttribute("nomeAttr", produto.getNome());
            request.setAttribute("tipoAttr", produto.getTipoProduto());
            request.setAttribute("QntdAttr", Double.toString(produto.getQtdProduto()));
            request.setAttribute("vlrUnitarioAttr", Double.toString(produto.getVlrUnitario()));
        } else {
            request.setAttribute("naoEncontradoAttr", true);
        }
        dispatcher.forward(request, response);
    }
        /*Criar classe para EDITAR PRODUTO*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-produto.jsp");
        String nome = request.getParameter("nome");
        try {
            ProdutoDAO.deletarProduto(nome);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispatcher.forward(request, response);
    }

}
