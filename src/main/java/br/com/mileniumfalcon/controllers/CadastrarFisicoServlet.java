package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.PessoaFisica;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CadastrarFisicoServlet", urlPatterns = {"/vendedor/cadastrar-fisico"})
public class CadastrarFisicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-fisico.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String cpf = request.getParameter("cpf");
            String dataNascimentoString = request.getParameter("dataNascimento");
            String email = request.getParameter("email");

            Timestamp dataInclusao = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date dataNascimento = formato.parse(dataNascimentoString);

            PessoaFisica cliente = new PessoaFisica(nome, endereco, cep, email,
                                                    cpf, dataNascimento);
            
            boolean salvou = ClienteDAO.salvarFisico(cliente);
            
            if (salvou) {
                request.setAttribute("criadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendedor.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-fisico.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFisicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
