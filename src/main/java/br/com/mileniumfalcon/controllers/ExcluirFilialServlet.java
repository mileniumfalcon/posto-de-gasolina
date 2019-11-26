/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ExcluirFilialServlet", urlPatterns = {"/diretor/excluir-filial"})
public class ExcluirFilialServlet extends HttpServlet {

    FilialDAO fiDao = new FilialDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        boolean excluiu;

        excluiu = fiDao.excluir(id);

        if (excluiu) {
            request.setAttribute("deletadoAttr", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/diretor.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pesquisar-filial.jsp");
            dispatcher.forward(request, response);
        }

    }
}
