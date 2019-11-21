package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FinalizarVendaServlet", urlPatterns = {"/FinalizarVendaServlet"})
public class FinalizarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        try {
            if(request.getParameter("idCliente") != null){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                Cliente cliente = ClienteDAO.pesquisarPorId(idCliente);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
