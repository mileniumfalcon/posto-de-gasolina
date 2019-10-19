package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.Cliente;
import java.io.IOException;
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
@WebServlet(name = "PesquisarCliente", urlPatterns = {"/vendedor/pesquisa-de-cliente"})
public class PesquisarClienteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String documento = request.getParameter("documento");
        Cliente cliente = ClienteDAO.pesquisarPorDocumento(documento);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-cliente.jsp");
        
           if (cliente != null) {
               request.setAttribute("idAttr", cliente.getId());
               request.setAttribute("nomeAttr", cliente.getNome());
               request.setAttribute("documentoAttr", cliente.getDocumento());
               request.setAttribute("tamanhoDocAttr", cliente.getDocumento());
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
