package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.models.BackOffice;
import br.com.mileniumfalcon.models.Diretor;
import br.com.mileniumfalcon.models.FilialModel;
import br.com.mileniumfalcon.models.Funcionario;
import br.com.mileniumfalcon.models.Rh;
import br.com.mileniumfalcon.models.Vendedor;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(name = "EditarFuncionarioServlet", urlPatterns = {"/rh/editar-funcionario"})
public class EditarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editar-funcionario.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<String> filiais = FuncionarioDAO.getFiliais();
        Funcionario funcionario = FuncionarioDAO.pesquisaPorId(id);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataNascimento = formato.format(funcionario.getDataNascimento());
        
        request.setAttribute("idAttr", id);
        request.setAttribute("filiaisAttr", filiais);
        request.setAttribute("nomeAttr", funcionario.getNome());
        request.setAttribute("enderecoAttr", funcionario.getEndereco());
        request.setAttribute("cepAttr", funcionario.getCep());
        request.setAttribute("cpfAttr", funcionario.getCpf());
        request.setAttribute("dataNascimentoAttr", dataNascimento);
        request.setAttribute("emailAttr", funcionario.getEmail());
        request.setAttribute("senhaAttr", funcionario.getSenha());

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String cpf = request.getParameter("cpf");
            String dataNascimentoString = request.getParameter("dataNascimento");
            String cargo = request.getParameter("cargo");            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Timestamp dataInclusao = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = formato.parse(dataNascimentoString);
            Funcionario funcionario;
            boolean salvou = false;
            
            if (cargo.equals("rh")) {
                funcionario = new Rh(email, senha, id, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = FuncionarioDAO.editar(funcionario);
            } else if (cargo.equals("diretor")) {
                funcionario = new Diretor(email, senha, id, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = FuncionarioDAO.editar(funcionario);
            } else if (cargo.equals("back-office")) {
                funcionario = new BackOffice(email, senha, id, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = FuncionarioDAO.editar(funcionario);
            } else if (cargo.equals("vendedor")) {
                String filialStr = request.getParameter("filial");
                FilialModel filial = FuncionarioDAO.getFilial(filialStr);
                Vendedor vendedor = new Vendedor(email, senha, id, nome, endereco, cpf, cep,
                        dataNascimento, dataInclusao, filial, false);
                salvou = FuncionarioDAO.editarVendedor(vendedor);
            } else if (cargo.equals("gerente-vendas")) {
                String filialStr = request.getParameter("filial");
                FilialModel filial = FuncionarioDAO.getFilial(filialStr);
                Vendedor vendedor = new Vendedor(email, senha, id, nome, endereco, cpf, cep,
                        dataNascimento, dataInclusao, filial, true);
                salvou = FuncionarioDAO.editarVendedor(vendedor);
            }
            
            if (salvou) {
                request.setAttribute("editadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/rh.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
