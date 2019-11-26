package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.models.Filial;
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
@WebServlet(name = "PesquisarFilialServlet", urlPatterns = {"/diretor/pesquisar-filial"})
public class PesquisarFilialServlet extends HttpServlet {
    
    FilialDAO fiDao = new FilialDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-filial.jsp");
        String nome = request.getParameter("nome");
        request.setAttribute("naoEncontradoAttr", null);
        if(nome != null){
        Filial filial = fiDao.pesquisarFilial(nome);

        if (filial.getNome() != null) {
            request.setAttribute("idfilial", Integer.toString(filial.getId()));
            request.setAttribute("nomefilial", filial.getNome());
            request.setAttribute("estadofilial", filial.getEstado());
            request.setAttribute("enderecofilial", filial.getEndereco());
            request.setAttribute("cepfilial", filial.getCep());
            request.setAttribute("naoEncontradoAttr", false);
        } if(filial.getNome() == null){
            request.setAttribute("naoEncontradoAttr", true);
        }}

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
