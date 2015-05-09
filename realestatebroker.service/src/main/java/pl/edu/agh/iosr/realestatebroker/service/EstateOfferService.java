package pl.edu.agh.iosr.realestatebroker.service;

import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;

import java.util.List;

/**
 * Created by grzegorz on 2015-05-09.
 */
public interface EstateOfferService {

    public EstateOffer findById(int id);

    public List<EstateOffer> findAll();

    public List<EstateOffer> findByTitle(String title);

    public void save (EstateOffer estateOffer);

    public void remove(int id);
}