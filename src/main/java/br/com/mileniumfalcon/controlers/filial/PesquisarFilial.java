/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers.filial;

import br.com.meleniumfalcon.model.models.FilialModel;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class PesquisarFilial extends HttpServlet {

    FilialControler filialController = new FilialControler();

    ArrayList<FilialModel> filiais = (ArrayList<FilialModel>) filialController.list();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("PesquisarFilial.jsp");

        if (filiais != null) {
                request.setAttribute("filiaisAttr", filiais);
        } 

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
