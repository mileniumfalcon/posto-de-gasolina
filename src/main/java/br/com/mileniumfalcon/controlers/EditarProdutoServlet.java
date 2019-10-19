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
@WebServlet(name = "EditarProdutoServlet", urlPatterns = {"/backoffice/editar-produto"})
public class EditarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-produto.jsp");
        ProdutoModel produto = ProdutoDAO.pesquisarParaEditar(id);

        try {
            if (produto != null) {

                request.setAttribute("nomeAttr", produto.getNome());
                request.setAttribute("precoAttr", produto.getVlrUnitario());
                request.setAttribute("qntAttr", produto.getQtdProduto());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
        int id = Integer.parseInt(request.getParameter("id"));

        String nome;
        String tipoProduto;
        double qtdProduto = 0;
        double vlrUnitario = 0;
            nome = request.getParameter("nome");
            tipoProduto = request.getParameter("tpProduto");

            try {
                vlrUnitario = Double.parseDouble(request.getParameter("preco"));
                qtdProduto = Double.parseDouble(request.getParameter("qtdProduto"));
            } catch (NullPointerException npe) {
                System.out.println(npe);

            } catch (NumberFormatException nfe) {
                System.out.println(nfe);
            }
            ProdutoModel produto = new ProdutoModel(nome, tipoProduto, qtdProduto, vlrUnitario);
            boolean editou = ProdutoDAO.editarProduto(produto, id);
            
            if (editou) {
                request.setAttribute("editadodoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/backoffice.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-produto.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
