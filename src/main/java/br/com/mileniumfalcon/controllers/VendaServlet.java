
package br.com.mileniumfalcon.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.Cliente;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/vendedor/vendas"})
public class VendaServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/venda-incluir-cliente.jsp");
        String documento = request.getParameter("documento");
        
        try{
            Cliente cliente = ClienteDAO.pesquisarPorDocumento(documento);
            if(cliente!=null){
                request.setAttribute("idCliente", cliente.getId());
                
            }
        }catch(Exception e){
            
        }
        dispatcher.forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
