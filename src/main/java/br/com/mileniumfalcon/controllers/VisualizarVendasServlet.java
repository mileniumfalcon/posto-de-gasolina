package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FuncionarioDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.services.RelatorioProdutoService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VisualizarVendasServlet", urlPatterns = {"/backoffice/visualizacao-de-vendas"})
public class VisualizarVendasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher;
            ArrayList<RelatorioProdutoService> produtos;
            
            String dataInicioString = request.getParameter("dataInicio");
            String dataFinalString = request.getParameter("dataFinal");
            String filialString = request.getParameter("filial");
            String vendas = request.getParameter("vendas");

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = formato.parse(dataInicioString);
            Date dataFinal = formato.parse(dataFinalString);
            Filial filial = FuncionarioDAO.getFilial(filialString);
            double totalVenda = VendaDAO.totalVendidoFilialData(dataInicio, dataFinal, filial.getId());

            if (vendas.equals("mais")) {
                dispatcher = request.getRequestDispatcher("/WEB-INF/mais-vendidos.jsp");
                produtos = VendaDAO.dezMaisVendidosFilialData(dataInicio, dataFinal, filial.getId());
                
            } else {
                dispatcher = request.getRequestDispatcher("/WEB-INF/menos-vendidos.jsp");
                produtos = VendaDAO.dezMenosVendidosFilialData(dataInicio, dataFinal, filial.getId());
            }
            
            if (produtos.isEmpty()) {
                    request.setAttribute("naoEncontradoAttr", true);
                } else {
                    request.setAttribute("produtosAttr", produtos);
                    request.setAttribute("filialAttr", filial.getNome());
                    request.setAttribute("totalAttr", totalVenda);
                }

            dispatcher.forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(VisualizarVendasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
