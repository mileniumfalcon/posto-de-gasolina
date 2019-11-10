package br.com.mileniumfalcon.models;

/**
 *
 * @author erick
 */
public class Usuario {
    
    private String email;
    private String senha;
    
    public Usuario (String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario () {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }
    
    public boolean verificarFuncao(String funcao) {
        return this.getClass().getSimpleName().equals(funcao);
    }
    
    public String montarUrl() {
        String funcao = this.getClass().getSimpleName();
        
        if (funcao.equalsIgnoreCase("GerenteVendas")) {
            return "/gerente-vendas";
        }
        
        return "/" + funcao;
    }
    
}
