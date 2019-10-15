/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.controlers;

import br.com.meleniumfalcon.model.models.FilialModel;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface IFilialInterface {

    public FilialModel insert(FilialModel filial);

    public FilialModel update(FilialModel filial);

    public FilialModel delete(FilialModel filial);

    public int getQuantidade();

    public List<FilialModel> list();

}
