/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Produto;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.ItemVenda;
import com.sun.xml.internal.ws.transport.http.HttpAdapter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "RealizarVenda", urlPatterns = {"/vendedor/realizar-venda"})
public class RealizarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
        int idFilial = FilialDAO.idFilialPorEmail(usuario.getEmail());
        
        List<Produto> produtos = ProdutoDAO.pesquisarProdutos(idFilial);
        try {
            if (produtos != null) {

                request.setAttribute("produtosAttr", produtos);

                request.getRequestDispatcher("/WEB-INF/realizar-venda.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            
             
             System.out.println("OPAAAA " +request.getAttribute("produtosAttr"));
             System.out.println("TESTAAAAAANDO "+request.getParameter("produto.getNome"));
             int idItem = Integer.parseInt(request.getParameter("idProduto"));
             double qtdItem = Double.parseDouble(request.getParameter("qtdItem"));
             
             Produto produto = ProdutoDAO.pesquisarPorId(idItem);
             ItemVenda item = new ItemVenda(produto, qtdItem);
             
             ArrayList<ItemVenda> itensVenda= new ArrayList<ItemVenda>();
             
             int i=0;
             while(i<0){
                 itensVenda.add(item);
                 i++;
             }
             i=0;
             
             
             request.setAttribute("itensAttr", itensVenda);
             
           
             
       
        } catch (Exception ex) {
            System.out.println("AQUIIIIIIIIIII" + ex);
        }

    }

    public static double valorCompra(double valorItem, double quantidade, double total) {
        total += (valorItem * quantidade);

        return total;
    }

}
