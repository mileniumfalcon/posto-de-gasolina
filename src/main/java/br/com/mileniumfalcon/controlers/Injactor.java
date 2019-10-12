package br.com.mileniumfalcon.controlers;

import br.com.mileniumfalcon.models.FilialModel;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author Victor
 */
public class Injactor {


    public static void services(AbstractBinder abstractBinder) {
        abstractBinder.bind(FilialController.class).to(FilialController.class);
    }


    public static void model(AbstractBinder abstractBinder) {
        abstractBinder.bind(FilialModel.class).to(FilialModel.class);
        
    }

}
     

