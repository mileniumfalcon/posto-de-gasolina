/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.services.RelatorioFilialService;
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
 * @author Victor
 */
@WebServlet(name = "PesquisarVendasDiretorServlet", urlPatterns = {"/diretor/pesquisa-de-vendas-filial"})
public class PesquisarVendasDiretorServlet extends HttpServlet {
    
    FilialDAO fDao = new FilialDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorios-diretor.jsp");
            String dataInicioString = request.getParameter("dataInicio");
            String dataFinalString = request.getParameter("dataFinal");

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
            Date dataFinal;
            Date dataInicio;
            int idFilial = fDao.idFilialPorEmail(usuario.getEmail());

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            dataInicio = formato.parse(dataInicioString);

            dataFinal = formato.parse(dataFinalString);
            //consulta todas as vendas entre o periodo determinado e retorna para uma lista
            ArrayList<RelatorioFilialService> filial = FilialDAO.consultarVendaTotaldeTodasFiliais(dataInicio, dataFinal);
            double valorTotal = 0;
            //percorre a lista e concatena o valor total de venda entre filiais para uma variavel
            for (RelatorioFilialService relatorioFilialService : filial) {
                valorTotal = relatorioFilialService.getValorTotalVendas()+ valorTotal;
            }
            //
            if (!filial.isEmpty()) {
                request.setAttribute("vendasAttr", filial);
                request.setAttribute("totalAttr", valorTotal);

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
