package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.PessoaFisica;
import java.io.IOException;
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
@WebServlet(name = "EditarFisicoServlet", urlPatterns = {"/vendedor/editar-fisico"})
public class EditarFisicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-fisico.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        PessoaFisica cliente = ClienteDAO.pesquisarFisicoPorId(id);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = formato.format(cliente.getDataNascimento());

        request.setAttribute("idAttr", id);
        request.setAttribute("nomeAttr", cliente.getNome());
        request.setAttribute("enderecoAttr", cliente.getEndereco());
        request.setAttribute("cepAttr", cliente.getCep());
        request.setAttribute("cpfAttr", cliente.getDocumento());
        request.setAttribute("dataNascimentoAttr", dataNascimento);
        request.setAttribute("emailAttr", cliente.getEmail());

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            
            int id = Integer.parseInt(request.getParameter("id"));

            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String cpf = request.getParameter("cpf");
            String dataNascimentoStr = request.getParameter("dataNascimento");
            String email = request.getParameter("email");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento;

            dataNascimento = formato.parse(dataNascimentoStr);

            PessoaFisica cliente = new PessoaFisica(id, nome, endereco, cep, email,
                    cpf, dataNascimento);

            boolean editou = ClienteDAO.editar(cliente);

            if (editou) {
                request.setAttribute("editadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendedor.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-fisico.jsp");
                dispatcher.forward(request, response);
            }

        } catch (ParseException ex) {
            Logger.getLogger(EditarFisicoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
