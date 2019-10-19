package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.models.Funcionario;
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
@WebServlet(name = "PesquisarFuncionarioServlet", urlPatterns = {"/rh/pesquisa-de-funcionario"})
public class PesquisarFuncionarioServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

           String cpf = request.getParameter("cpf");
           Funcionario funcionario = FuncionarioDAO.pesquisaPorCpf(cpf);
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-funcionario.jsp");
           if (funcionario != null) {
               request.setAttribute("idAttr", funcionario.getId());
               request.setAttribute("nomeAttr", funcionario.getNome());
               request.setAttribute("cpfAttr", funcionario.getCpf());
               request.setAttribute("dptoAttr", funcionario.getClass().getSimpleName());
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
