/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Produto;
import java.io.IOException;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-produto.jsp");
        String nome = request.getParameter("nome");

        Produto produto = ProdutoDAO.pesquisarProduto(nome);

        if (produto.getNome() != null) {
            request.setAttribute("idAttr", Integer.toString(produto.getId()));
            request.setAttribute("nomeAttr", produto.getNome());
            request.setAttribute("QntdAttr", Double.toString(produto.getQtdProduto()));
            request.setAttribute("vlrUnitarioAttr", Double.toString(produto.getVlrUnitario()));
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
