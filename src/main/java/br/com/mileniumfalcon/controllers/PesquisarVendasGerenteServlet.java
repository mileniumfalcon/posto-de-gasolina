package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.Venda;
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
@WebServlet(name = "PesquisarVendasGerenteServlet", urlPatterns = {"/gerente-vendas/pesquisa-de-vendas"})
public class PesquisarVendasGerenteServlet extends HttpServlet {
    
    FilialDAO fiDao = new FilialDAO();
    VendaDAO vDao = new VendaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-vendas-gerente.jsp");
            String dataInicioString = request.getParameter("dataInicio");
            String dataFinalString = request.getParameter("dataFinal");

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");

            int idFilial = fiDao.idFilialPorEmail(usuario.getEmail());

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = formato.parse(dataInicioString);
            Date dataFinal;

            dataFinal = formato.parse(dataFinalString);

            ArrayList<Venda> vendas = vDao.getVendasPorData(dataInicio, dataFinal, idFilial);

            if (!vendas.isEmpty()) {
                request.setAttribute("vendasAttr", vendas);

            } else {
                request.setAttribute("naoEncontradoAttr", true);
            }

            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(PesquisarVendasGerenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
