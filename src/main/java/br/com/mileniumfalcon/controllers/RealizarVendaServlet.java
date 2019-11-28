package br.com.mileniumfalcon.controllers;

import br.com.mileniumfalcon.dao.ClienteDAO;
import br.com.mileniumfalcon.dao.FilialDAO;
import br.com.mileniumfalcon.dao.ProdutoDAO;
import br.com.mileniumfalcon.models.Cliente;
import br.com.mileniumfalcon.models.Produto;
import br.com.mileniumfalcon.models.Usuario;
import br.com.mileniumfalcon.models.ItemVenda;
import java.io.IOException;
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
@WebServlet(name = "RealizarVenda", urlPatterns = {"/vendedor/realizar-venda"})
public class RealizarVendaServlet extends HttpServlet {
    
    ClienteDAO cDao = new ClienteDAO();
    FilialDAO fiDao = new FilialDAO();
    ProdutoDAO pDao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
        int idFilial = fiDao.idFilialPorEmail(usuario.getEmail());

        if (sessao.getAttribute("clienteAttr") == null && request.getParameter("id")!= null) {
            int idCliente = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = cDao.pesquisarPorId(idCliente);
            sessao.setAttribute("clienteAttr", cliente);
        }

        List<Produto> produtos = pDao.pesquisarProdutos(idFilial);
        try {
            if (produtos != null) {
                request.setAttribute("produtosAttr", produtos);
                request.getRequestDispatcher("/WEB-INF/realizar-venda.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession sessao = request.getSession();

            if (sessao.getAttribute("itensAttr") == null) {
                sessao.setAttribute("itensAttr", new ArrayList<ItemVenda>());
            }
            List<ItemVenda> itensVenda = (List<ItemVenda>) sessao.getAttribute("itensAttr");
            
            if (request.getParameter("idProduto") == null) {
                sessao.setAttribute("semProdutoMsg", "Nenhum produto selecionado!");
                response.sendRedirect(request.getContextPath() + "/vendedor/realizar-venda");
            }
                 
            int idItem = Integer.parseInt(request.getParameter("idProduto"));
            double qtdItem = Double.parseDouble(request.getParameter("qtdItem"));
            double total = 0;

            Produto produto = pDao.pesquisarPorId(idItem);
            ItemVenda item = new ItemVenda(produto, qtdItem);

            if (item.qtdPermitida()) {
                itensVenda.add(item);
                for (int i = 0; i < itensVenda.size(); i++) {
                    total = total + itensVenda.get(i).vlrTotalItem();
                }
                sessao.setAttribute("totalAttr", total);
                response.sendRedirect(request.getContextPath() + "/vendedor/realizar-venda");
            } else {
                sessao.setAttribute("naoPermitidoMsg", "Quantidade não permitida!");
                response.sendRedirect(request.getContextPath() + "/vendedor/realizar-venda");
            }
        } catch (Exception ex) {
            System.out.println("AQUIIIIIIIIIII" + ex);
        }
    }
}
