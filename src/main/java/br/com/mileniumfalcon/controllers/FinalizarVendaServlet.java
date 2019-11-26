package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.VendaDAO;
import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.Filial;
import br.com.mileniumfalcon.models.ItemVenda;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.Venda;
import java.io.IOException;
import java.sql.Timestamp;
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

    FilialDAO fiDao = new FilialDAO();
    VendaDAO vDao = new VendaDAO();

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
            Venda venda;
            Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
            int idFilial = fiDao.idFilialPorEmail(usuario.getEmail());
            List<ItemVenda> itensVenda = (ArrayList<ItemVenda>) sessao.getAttribute("itensAttr");
            Filial filial = fiDao.pesquisarFilialPorID(idFilial);
            Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
            double totalCompra = 0;

            for (int i = 0; i < itensVenda.size(); i++) {
                totalCompra = totalCompra + itensVenda.get(i).vlrTotalItem();
            }

            if (sessao.getAttribute("clienteAttr") == null) {
                venda = new Venda(totalCompra, dataVenda, filial, (ArrayList<ItemVenda>) itensVenda);
            } else {
                Cliente cliente = (Cliente) sessao.getAttribute("clienteAttr");
                venda = new Venda(totalCompra, dataVenda, cliente, filial, (ArrayList<ItemVenda>) itensVenda);
            }

            boolean salvou = vDao.salvar(venda);
            
            if (salvou) {
                request.setAttribute("vendaAttr", true);
                sessao.removeAttribute("clienteAttr");
                sessao.removeAttribute("itensAttr");
                sessao.removeAttribute("produtosAttr");
                sessao.removeAttribute("itensAttr");
                sessao.removeAttribute("totalAttr");
                request.getRequestDispatcher("/WEB-INF/venda-finalizada.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
