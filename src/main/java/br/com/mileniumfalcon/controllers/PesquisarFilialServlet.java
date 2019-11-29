package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.models.Filial;
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
 * @author Victor
 */
@WebServlet(name = "PesquisarFilialServlet", urlPatterns = {"/diretor/pesquisar-filial"})
public class PesquisarFilialServlet extends HttpServlet {

    FilialDAO fiDao = new FilialDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-filial.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-filial.jsp");
        String nome = request.getParameter("nome");

        ArrayList<Filial> filiais = fiDao.pesquisarFilial(nome);

        if (!filiais.isEmpty()) {
            request.setAttribute("filiaisAttr", filiais);
        } else {
            request.setAttribute("naoEncontradoAttr", true);
        }

        dispatcher.forward(request, response);

    }
}
