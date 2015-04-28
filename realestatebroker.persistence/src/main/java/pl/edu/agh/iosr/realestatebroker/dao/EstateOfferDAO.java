package pl.edu.agh.iosr.realestatebroker.dao;

import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;
import java.util.List;

public interface EstateOfferDAO {

    public EstateOffer getEstateOffer (long id);

    public List<EstateOffer> findEstateOffer();

    public List<EstateOffer> findEstateOffer(String key);

    public void saveEstateOffer (EstateOffer estateOffer);

    public void removeEstateOffer(long id);
}