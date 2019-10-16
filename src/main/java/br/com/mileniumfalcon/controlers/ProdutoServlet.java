/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;
import br.com.mileniumfalcon.models.FilialModel;
import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.mileniumfalcon.models.ProdutoModel;
import com.sun.rmi.rmid.ExecOptionPermission;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author pablo.osantana
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/backoffice/cadastrar-produto"})
public class ProdutoServlet extends HttpServlet {

    
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastrar-produto.jsp");
        //request.setAttribut("filiaisAttr");
        int id;
        
        
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome;
        String tipoProduto;
        double qtdProduto=0;
        double vlrUnitario=0;
        try{
        nome = request.getParameter("nome");
        tipoProduto = request.getParameter("tpProduto");
        
       
        
        
        try{
            vlrUnitario = Double.parseDouble(request.getParameter("preco"));
            qtdProduto = Double.parseDouble(request.getParameter("qtdProduto"));
        }catch(NullPointerException npe){
            
        }catch (NumberFormatException nfe) {
        }
        
    
//        int filial;
//        if(request.getParameter("filial").equalsIgnoreCase("São Paulo")){
//            filial = 1;
//        }else if(request.getParameter("filial").equalsIgnoreCase("Minas Gerais")){
//            filial = 2;
//        }else if(request.getParameter("filial").equalsIgnoreCase("Rio de Janeiro")){
//            filial = 3;
//        }else{
//            filial = 0;
//        }
       
        
        ProdutoModel produto = new ProdutoModel(nome, tipoProduto, qtdProduto,vlrUnitario);
            try {
                ProdutoDAO.salvar(produto);
                request.setAttribute("criadoAttr", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/backoffice.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         }catch(NumberFormatException ex){
             Logger.getLogger(ProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    

}
}
