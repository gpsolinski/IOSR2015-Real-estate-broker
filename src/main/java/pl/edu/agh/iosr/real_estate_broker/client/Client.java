package pl.edu.agh.iosr.real_estate_broker.client;

import pl.edu.agh.iosr.real_estate_broker.AddFlatInfoEndpointService;
import pl.edu.agh.iosr.real_estate_broker.AddFlatInfoPortType;
import pl.edu.agh.iosr.real_estate_broker.FlatInfo;
import pl.edu.agh.iosr.real_estate_broker.FlatInfoResponse;

import javax.xml.ws.BindingProvider;

public class Client {
    public static void main(String... args) {

        AddFlatInfoEndpointService service = new AddFlatInfoEndpointService();
        AddFlatInfoPortType portType = service.getAddFlatInfoPort();
        BindingProvider provider = (BindingProvider) portType;

        FlatInfo in = new FlatInfo();
        in.setAddress("Krupnicza 7");
        in.setPhone("123456789");
        in.setRooms(3);
        in.setSize(46);

        FlatInfoResponse response = portType.addFlatInfo(in);
        System.out.println("Response: " + response.getCode());
    }
}
