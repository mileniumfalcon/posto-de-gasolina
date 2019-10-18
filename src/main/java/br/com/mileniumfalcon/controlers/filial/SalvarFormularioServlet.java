/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers.filial;

import br.com.meleniumfalcon.model.models.ClienteModel;
import br.com.meleniumfalcon.model.models.FilialModel;
import br.com.mileniumfalcon.controlers.cliente.ClienteControler;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import br.com.mileniumfalcon.model.dao.IRepository;
import br.com.mileniumfalcon.controlers.filial.FilialControler;
import br.com.mileniumfalcon.controlers.filial.FilialControler;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "SalvarFormularioServlet", urlPatterns = {"/formulario/salvar"})
public class SalvarFormularioServlet extends HttpServlet {

   FilialModel filialModel = new FilialModel();
   FilialControler filialController = new FilialControler();
      ClienteModel clienteModel = new ClienteModel();
    ClienteControler clienteControler = new ClienteControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nomefilial");
        String endereco = request.getParameter("enderecofilial");
         String estado = request.getParameter("estadofilial");
        
        
        
        
   

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("enderecoAttr", endereco); 
        request.setAttribute("estadofilial", estado); 

           filialModel.setNome(nome);
            filialModel.setEndereco(endereco);
            filialModel.setEstado(estado);
            filialModel = filialController.insert(filialModel);
             
           if(filialModel != null){
                // deu certo
                System.out.println(filialModel.getNome());
           
            } else {
                // deu errado
                System.out.println("Deu Errado");
            }
            RequestDispatcher dispatcher  = request.getRequestDispatcher("/WEB-INF/resultado.jsp");
                 dispatcher.forward(request, response);
        }
         
    

}
