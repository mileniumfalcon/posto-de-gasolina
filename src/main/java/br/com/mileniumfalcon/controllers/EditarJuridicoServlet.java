package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.models.PessoaJuridica;
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
@WebServlet(name = "EditarJuridicoServlet", urlPatterns = {"/vendedor/editar-juridico"})
public class EditarJuridicoServlet extends HttpServlet {
    
    ClienteDAO cDao = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-juridico.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        PessoaJuridica cliente = cDao.pesquisarJuridicoPorId(id);

        request.setAttribute("idAttr", id);
        request.setAttribute("nomeAttr", cliente.getNome());
        request.setAttribute("enderecoAttr", cliente.getEndereco());
        request.setAttribute("cepAttr", cliente.getCep());
        request.setAttribute("cnpjAttr", cliente.getDocumento());
        request.setAttribute("telefoneAttr", cliente.getTelefone());
        request.setAttribute("emailAttr", cliente.getEmail());

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        
        PessoaJuridica cliente = new PessoaJuridica(id, nome, endereco, cep, email,
                cnpj, telefone);
        boolean editou = cDao.editar(cliente);
        if (editou) {
            request.setAttribute("editadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vendedor.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-juridico.jsp");
            dispatcher.forward(request, response);
        }
    }
}
