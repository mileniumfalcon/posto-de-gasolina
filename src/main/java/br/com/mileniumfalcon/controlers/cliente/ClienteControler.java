package br.com.mileniumfalcon.controlers.cliente;

import br.com.mileniumfalcon.controlers.IClienteControler;
import br.com.meleniumfalcon.model.models.ClienteModel;
import br.com.mileniumfalcon.controlers.Controler;
import br.com.mileniumfalcon.model.dao.ClienteRepository;
import br.com.mileniumfalcon.model.dao.IClienteRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ClienteControler extends Controler implements IClienteControler {
    
        private final IClienteRepository iClienteRepository;
    
    public ClienteControler(){
        iClienteRepository = new ClienteRepository();
    }

    @Override
    public ClienteModel insert(ClienteModel cliente) {
           try {
            if (cliente != null) {
                getConnectOpen();
               cliente.setId(iClienteRepository.insertPessoaFisica(cliente.getEntity(), getConnect()));
                getConnectClose();
                return cliente;
            }

        } catch (SQLException e) {
            getConnectClose();
        }

        return null;
    }

    @Override
    public ClienteModel update(ClienteModel cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteModel delete(ClienteModel cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQuantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteModel> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
