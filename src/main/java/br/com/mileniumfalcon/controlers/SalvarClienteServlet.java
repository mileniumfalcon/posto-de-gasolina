/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;

import br.com.meleniumfalcon.model.models.ClienteModel;
import br.com.meleniumfalcon.model.models.FilialModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.meleniumfalcon.model.models.FilialModel;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
@WebServlet(name = "SalvarClienteServlet", urlPatterns = {"/cliente/cadastro-cliente"})
public class SalvarClienteServlet extends HttpServlet{



 ClienteModel clienteModel = new ClienteModel();
    ClienteControler clienteController = new ClienteControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");
        String numerSorteStr = request.getParameter("numeroSorte");
        String alturaStr = request.getParameter("altura");
        String pesoStr = request.getParameter("peso");
        String dtNascimentoStr = request.getParameter("dtNascimento");
        String sexoStr = request.getParameter("sexo");
        String[] interesses = request.getParameterValues("interesses");

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("senhaAttr", senha);
        request.setAttribute("alturaAttr", alturaStr);
        request.setAttribute("dtNascimentoAttr", dtNascimentoStr);
        request.setAttribute("sexoAttr", sexoStr);
        request.setAttribute("interessesAttr", interesses);

        // Validacao
        boolean temErros = false;
        // Validacao do nome
        if (nome == null || nome.trim().length() < 1) {
            temErros = true;
            request.setAttribute("erroNome", true);
        }
        // Validacao de senhas iguais
        if (senha != null) {
            if (!senha.contentEquals(repetirSenha)) {
                temErros = true;
                request.setAttribute("erroSenha", true);
            }
        } else {
            if (repetirSenha != null) {
                temErros = true;
                request.setAttribute("erroSenha", true);
            }
        }

        if (temErros) {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/formulario.jsp");
            dispatcher.forward(request, response);
        } else {

            clienteModel.setNome(nome);
            clienteModel.setEndereco(descricao);
           
            clienteModel = clienteController.insert(clienteModel);
            
            if(clienteModel != null){
                // deu certo
            } else {
                // deu errado
            }
        }

        RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/resultado.jsp");
        dispatcher.forward(request, response);
    }

}

    

