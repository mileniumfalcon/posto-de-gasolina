package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.PessoaJuridica;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CadastrarJuridicoServlet", urlPatterns = {"/vendedor/cadastrar-juridico"})
public class CadastrarJuridicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-juridico.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String cnpj = request.getParameter("cnpj");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");

            PessoaJuridica cliente = new PessoaJuridica(nome, endereco, cep, email,
                                                    cnpj, telefone);
            
            boolean salvou = ClienteDAO.salvarJuridico(cliente);
            
            

            if (salvou) {
                request.setAttribute("criadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendedor.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-fisico.jsp");
                dispatcher.forward(request, response);
            }
        

    }
}