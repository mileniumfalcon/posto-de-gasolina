package br.com.mileniumfalcon.controlers;

import br.com.meleniumfalcon.model.models.FilialModel;
import br.com.mileniumfalcon.model.dao.FililalRepository;
import br.com.mileniumfalcon.model.dao.IFilialRepository;
import br.com.mileniumfalcon.model.entity.FilialEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
public class FilialController extends Controler implements IFilialInterface {

    private final IFilialRepository iFilialRepository;
    
    public FilialController(){
        iFilialRepository = new FililalRepository();
    }

    @Override
    public FilialModel insert(FilialModel filial) {

        try {
            if (filial != null) {
                getConnectOpen();
                filial.setId(iFilialRepository.insert(filial.getEntity(), getConnect()));
                getConnectClose();
                return filial;
            }

        } catch (SQLException e) {
            getConnectClose();
        }

        return null;
    }

    @Override
    public FilialModel update(FilialModel filial) {

        try {
            if (filial != null) {
                getConnectOpen();
                boolean update = iFilialRepository.update(filial.getEntity(), getConnect());
                getConnectClose();

                if (update) {
                    return filial;
                }
            }

        } catch (SQLException e) {
            getConnectClose();
        }

        return null;
    }

    @Override
    public FilialModel delete(FilialModel filial) {

        try {
            if (filial != null) {
                getConnectOpen();
                boolean update = iFilialRepository.delete(filial.getEntity(), getConnect());
                getConnectClose();

                if (update) {
                    return filial;
                }
            }

        } catch (SQLException e) {
            getConnectClose();
        }

        return null;
    }

    @Override
    public int getQuantidade() {

        try {
            getConnectOpen();
            int count = iFilialRepository.getQuantidade(getConnect());
            getConnectClose();
            return count;
        } catch (SQLException e) {
            getConnectClose();
        }

        return 0;
    }

    @Override
    public List<FilialModel> list() {

        try {
            getConnectOpen();
            List<FilialEntity> entitys = iFilialRepository.list(getConnect());
            getConnectClose();

            List<FilialModel> filialModels = new ArrayList<>();
            entitys.forEach((item) -> {
                FilialModel filialModel = new FilialModel();
                filialModel.setId(item.getId());
                filialModel.setNome(item.getNome());
                filialModel.setEstado(item.getEstado());
                filialModel.setEndereco(item.getEndereco());
                filialModels.add(filialModel);
            });

            return filialModels;

        } catch (SQLException e) {
            getConnectClose();
        }

        return null;
    }

}
