/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;

import br.com.meleniumfalcon.model.models.ClienteModel;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IClienteControler {
        public ClienteModel insert(ClienteModel cliente);

    public ClienteModel update(ClienteModel cliente);

    public ClienteModel delete(ClienteModel cliente);

    public int getQuantidade();

    public List<ClienteModel> list();
}
