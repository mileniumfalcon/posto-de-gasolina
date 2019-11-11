/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "RealizarVenda", urlPatterns = {"/vendedor/realizar-venda"})
public class RealizarVenda extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/realizar-venda.jsp");
        dispatcher.forward(request, response);
        
        ArrayList<Produto> produto = ProdutoDAO.pesquisarProdutos();
        try{
            if(!produto.isEmpty()){
               
                    request.setAttribute("produtosAttr", produto);
                   
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
