package pl.edu.agh.iosr.realestatebroker.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.EstateOfferDAO;
import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;
import pl.edu.agh.iosr.realestatebroker.service.EstateOfferService;

import java.util.List;

/**
 * Created by grzegorz on 2015-05-09.
 */
public class EstateOfferServiceImpl implements EstateOfferService{

    private static final transient Log LOG = LogFactory.getLog(EstateOfferServiceImpl.class);

    private EstateOfferDAO estateOfferDAO;

    @Override
    public EstateOffer findById(int id) {
        return estateOfferDAO.findById(id);
    }

    @Override
    public List<EstateOffer> findAll() {
        return  estateOfferDAO.findAll();
    }

    @Override
    public List<EstateOffer> findByTitle(String title) {
        return estateOfferDAO.findByTitle(title);
    }

    @Override
    public void save(EstateOffer estateOffer) {
        estateOfferDAO.save(estateOffer);
    }

    @Override
    public void remove(int id) {
        estateOfferDAO.remove(id);
    }

}
