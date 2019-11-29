package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.models.BackOffice;
import br.com.mileniumfalcon.models.Diretor;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.Funcionario;
import br.com.mileniumfalcon.models.GerenteVendas;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick.ogurian
 */
@WebServlet(name = "CadastrarFuncionarioServlet", urlPatterns = {"/rh/cadastrar-funcionario"})
public class CadastrarFuncionarioServlet extends HttpServlet {
    
    FuncionarioDAO fDao = new FuncionarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
           RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-funcionario.jsp");
           ArrayList<String> filiais = fDao.getFiliais();
            
           request.setAttribute("filiaisAttr", filiais);
        
           dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        try {
            request.setCharacterEncoding("UTF-8");
            
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String cpf = request.getParameter("cpf");
            String dataNascimentoString = request.getParameter("dataNascimento");
            String cargo = request.getParameter("cargo");            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            boolean existeCpf = fDao.buscaCpf(cpf);
            
            if (existeCpf) {
                sessao.setAttribute("jaExisteCpf", "Já existe um funcionário com este cpf");
                response.sendRedirect(request.getContextPath() + "/rh/cadastrar-funcionario");
                return;
            }
            
            boolean existeEmail = fDao.buscaEmail(email);
            
            if (existeEmail) {
                sessao.setAttribute("jaExisteEmail", "Já existe um funcionário com este email");
                response.sendRedirect(request.getContextPath() + "/rh/cadastrar-funcionario");
                return;
            }
            
            Timestamp dataInclusao = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = formato.parse(dataNascimentoString);
            Funcionario funcionario;
            boolean salvou = false;
            
            if (cargo.equals("rh")) {
                funcionario = new Rh(email, senha, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = fDao.salvar(funcionario);
            } else if (cargo.equals("diretor")) {
                funcionario = new Diretor(email, senha, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = fDao.salvar(funcionario);
            } else if (cargo.equals("back-office")) {
                funcionario = new BackOffice(email, senha, nome, endereco, cpf, cep, dataNascimento, dataInclusao);
                salvou = fDao.salvar(funcionario);
            } else if (cargo.equals("vendedor")) {
                String filialStr = request.getParameter("filial");
                Filial filial = fDao.getFilial(filialStr);
                Vendedor vendedor = new Vendedor(email, senha, nome, endereco, cpf, cep,
                        dataNascimento, dataInclusao, filial);
                salvou = fDao.salvarVendedor(vendedor);
            } else if (cargo.equals("gerente-vendas")) {
                String filialStr = request.getParameter("filial");
                Filial filial = fDao.getFilial(filialStr);
                
                GerenteVendas gerente = new GerenteVendas(email, senha, nome, endereco, cpf, cep,
                        dataNascimento, dataInclusao, filial);
                salvou = fDao.salvarVendedor(gerente);
            }
            
            if (salvou) {
                request.setAttribute("criadoAttr", true);
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
