package pl.edu.agh.iosr.realestatebroker.internal;

import org.apache.camel.Exchange;
import pl.edu.agh.iosr.realestatebroker.model.EstateOffer;
import pl.edu.agh.iosr.realestatebroker.model.EstateType;
import pl.edu.agh.iosr.realestatebroker.webservice.EstateInfo;

public class WebService {
    public void process(Exchange exchange) {
        EstateInfo info = (EstateInfo)exchange.getIn().getBody();

        EstateOffer offer = new EstateOffer();
        offer.setTitle(info.getTitle());
        offer.setOwner(null);
        offer.setEstateType(info.getEstateType() == 0 ? EstateType.HOUSE : EstateType.APARTAMENT);
        offer.setDescription(info.getDescription());
        offer.setTotalArea(info.getTotalArea());
        offer.setLivingArea(info.getLivingArea());
        offer.setFrontYardArea(info.getFrontYardArea());
        offer.setBackYardArea(info.getBackYardArea());
        offer.setNumberOfBedrooms(info.getNumberOfBedrooms());
        offer.setNumberOfFloors(info.getNumberOfFloors());
        offer.setFloorNumber(info.getFloorNumber());
        offer.setGarageForCars(info.getGarageForCars());
        offer.setSeparateKitchen(info.isSeparateKitchen());
    }
}
