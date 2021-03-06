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
 * @author Pablo de Oliveira
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/vendedor/venda-incluir-cliente"})
public class IncluirClienteServlet extends HttpServlet {

    ClienteDAO cDao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/venda-incluir-cliente.jsp");
        
        if (request.getParameter("documento") != null) {
            String documento = request.getParameter("documento");
            Cliente cliente = cDao.pesquisarPorDocumento(documento);

            if (cliente != null) {
                request.setAttribute("idAttr", cliente.getId());
                request.setAttribute("nomeAttr", cliente.getNome());
                request.setAttribute("documentoAttr", cliente.getDocumento());
                request.setAttribute("tamanhoDocAttr", cliente.getDocumento());

            } else {
                request.setAttribute("naoEncontradoAttr", true);
            }
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
