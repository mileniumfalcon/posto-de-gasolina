package br.com.mileniumfalcon.filter;

import br.com.mileniumfalcon.models.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick
 */
@WebFilter(filterName = "AutorizacaoFilter",
        urlPatterns = { "/backoffice/*",
                        "/rh/*",
                        "/diretor/*",
                        "/vendedor/*",
                        "/gerente-vendas/*" })
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sessao = httpRequest.getSession();
        
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        if (verificarAutorizacao(usuario, httpRequest)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }
    }
    
    private boolean verificarAutorizacao(Usuario usuario, 
            HttpServletRequest httpRequest) {
        String urlAcessada = httpRequest.getRequestURI();
        
        if (urlAcessada.contains("/rh") && usuario.verificarFuncao("Rh")) {
            return true;
        } else if (urlAcessada.contains("/backoffice") && usuario.verificarFuncao("BackOffice")) {
            return true;
        } else if (urlAcessada.contains("/diretor") && usuario.verificarFuncao("Diretor")) {
            return true;
        } else if (urlAcessada.contains("/vendedor") && usuario.verificarFuncao("Vendedor")) {
            return true;
        } else if (urlAcessada.contains("/gerente-vendas") && usuario.verificarFuncao("GerenteVendas")) {
            return true;
        }
        
        return false;
    }

    @Override
    public void destroy() {        
    }
    
    @Override
    public void init(FilterConfig filterConfig) {          
    }
}