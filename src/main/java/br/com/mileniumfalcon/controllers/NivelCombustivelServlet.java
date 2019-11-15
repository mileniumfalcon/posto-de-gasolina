package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Produto;
import br.com.mileniumfalcon.models.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erick
 */
@WebServlet(name = "NivelCombustivelServlet", urlPatterns = {"/gerente-vendas/nivel-combustivel"})
public class NivelCombustivelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
   
        int idFilial = FilialDAO.idFilialPorEmail(usuario.getEmail());
        ArrayList<Produto> produtos = ProdutoDAO.combustivelPorFilial(idFilial);
        
         if (!produtos.isEmpty()) {
            request.setAttribute("produtosAttr", produtos);
            
        } else {
            request.setAttribute("naoEncontradoAttr", true);
        }
        
        request.getRequestDispatcher("/WEB-INF/nivel-combustivel.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
