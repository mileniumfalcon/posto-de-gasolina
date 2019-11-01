package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.PessoaFisica;
import java.io.IOException;
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
@WebServlet(name = "CadastrarFilialServlet", urlPatterns = {"/diretor/cadastrar-filial"})
public class CadastrarFilialServlet extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-filial.jsp");

        dispatcher.forward(request, response);

    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String estado = request.getParameter("estado");
        Filial filial = new Filial(nome,estado,endereco,cep);
        boolean salvou = FilialDAO.insertFilial(filial);
        if (salvou) {
            request.setAttribute("criadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-filial.jsp");
            dispatcher.forward(request, response);
        } 
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-filial.jsp");

        }

    }
}
