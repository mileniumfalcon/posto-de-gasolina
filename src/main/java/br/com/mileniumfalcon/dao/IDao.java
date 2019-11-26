package br.com.mileniumfalcon.dao;

/**
 *
 * @author erick.ogurian
 */
public interface IDao {
    
    public boolean salvar(Object object);
    
    public boolean editar(Object object);
    
    public boolean excluir(int id);
    
}
