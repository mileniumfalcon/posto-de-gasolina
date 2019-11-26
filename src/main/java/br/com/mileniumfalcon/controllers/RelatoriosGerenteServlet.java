package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.services.RelatorioProdutoService;
import java.io.IOException;
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
@WebServlet(name = "RelatoriosGerenteServlet", urlPatterns = {"/gerente-vendas/relatorios-gerente"})
public class RelatoriosGerenteServlet extends HttpServlet {
    
    FilialDAO fiDao = new FilialDAO();
    VendaDAO vDao = new VendaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorios-gerente.jsp");

            String dataString = request.getParameter("data");
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
            int idFilial = fiDao.idFilialPorEmail(usuario.getEmail());
            Date data;

            if (dataString.equals("atual")) {
                Date dataAtual = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataS = formato.format(dataAtual);
                data = formato.parse(dataS);
                request.setAttribute("dataAttr", dataS);

            } else {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                data = formato.parse(dataString);
                request.setAttribute("dataAttr", dataString);
            }

            ArrayList<RelatorioProdutoService> produtos = vDao.dezMaisVendidosFilial(data, idFilial);
            double totalVenda = vDao.totalVendidoFilial(data, idFilial);

            if (!produtos.isEmpty()) {
                request.setAttribute("produtosAttr", produtos);
                request.setAttribute("totalAttr", totalVenda);

            } else {
                request.setAttribute("naoEncontradoAttr", true);
            }

            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RelatoriosGerenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
