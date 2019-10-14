package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.models.Funcionario;
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
 * @author erick
 */
@WebServlet(name = "EditarFuncionarioServlet", urlPatterns = {"/rh/editar-funcionario"})
public class EditarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-funcionario.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<String> filiais = FuncionarioDAO.getFiliais();
        Funcionario funcionario = FuncionarioDAO.pesquisaPorId(id);

        request.setAttribute("filiaisAttr", filiais);
        request.setAttribute("nomeAttr", funcionario.getNome());
        request.setAttribute("enderecoAttr", funcionario.getEndereco());
        request.setAttribute("cepAttr", funcionario.getCep());
        request.setAttribute("cpfAttr", funcionario.getCpf());
        request.setAttribute("dataNascimentoAttr", funcionario.getDataNascimento());
        request.setAttribute("emailAttr", funcionario.getEmail());
        request.setAttribute("senhaAttr", funcionario.getSenha());

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
