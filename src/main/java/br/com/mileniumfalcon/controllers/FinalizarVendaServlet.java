package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.ItemVenda;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo de Oliveira
 */
@WebServlet(name = "FinalizarVendaServlet", urlPatterns = {"/vendedor/venda-finalizada"})
public class FinalizarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("vendaAttr", true);
        request.getRequestDispatcher("/WEB-INF/venda-finalizada.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessao = request.getSession();

        try {
            
            if (sessao.getAttribute("clienteAttr") == null) {

                Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");

                int idFilial = FilialDAO.idFilialPorEmail(usuario.getEmail());
                //int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                List<ItemVenda> itensVenda = (ArrayList<ItemVenda>) sessao.getAttribute("itensAttr");
                Filial filial = FilialDAO.pesquisarFilialPorID(idFilial);
                //Cliente cliente = ClienteDAO.pesquisarPorId(idCliente);
                Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                double totalCompra = 0;
                for (int i = 0; i < itensVenda.size(); i++) {
                    totalCompra = totalCompra + itensVenda.get(i).vlrTotalItem();
                }
                Venda venda = new Venda(totalCompra, dataVenda, filial, (ArrayList<ItemVenda>) itensVenda);
                boolean salvou = VendaDAO.salvar(venda);
                if (salvou) {
                    request.setAttribute("vendaAttr", true);
                    request.getRequestDispatcher("/WEB-INF/venda-finalizada.jsp").forward(request, response);
                    sessao.removeAttribute("clienteAttr");
                    sessao.removeAttribute("itensAttr");
                    sessao.removeAttribute("produtosAttr");
                    sessao.removeAttribute("itensAttr");
                    sessao.removeAttribute("totalAttr");
                }
            } else {

                Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");

                int idFilial = FilialDAO.idFilialPorEmail(usuario.getEmail());
                Cliente cliente = (Cliente) sessao.getAttribute("clienteAttr");
                List<ItemVenda> itensVenda = (ArrayList<ItemVenda>) sessao.getAttribute("itensAttr");
                Filial filial = FilialDAO.pesquisarFilialPorID(idFilial);

                Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                double totalCompra = 0;
                for (int i = 0; i < itensVenda.size(); i++) {
                    totalCompra = totalCompra + itensVenda.get(i).vlrTotalItem();
                }
                Venda venda = new Venda(totalCompra, dataVenda, cliente, filial, (ArrayList<ItemVenda>) itensVenda);

                boolean salvou = VendaDAO.salvar(venda);
                if (salvou) {
                    request.setAttribute("vendaAttr", true);
                    request.getRequestDispatcher("/WEB-INF/venda-finalizada.jsp").forward(request, response);
                    sessao.removeAttribute("clienteAttr");
                    sessao.removeAttribute("itensAttr");
                    sessao.removeAttribute("produtosAttr");
                    sessao.removeAttribute("itensAttr");
                    sessao.removeAttribute("totalAttr");
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
}
