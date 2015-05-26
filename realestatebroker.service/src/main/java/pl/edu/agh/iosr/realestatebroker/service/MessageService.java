package pl.edu.agh.iosr.realestatebroker.service;

import pl.edu.agh.iosr.realestatebroker.model.Message;

import java.util.List;

/**
 * Created by selmerin on 26.05.15.
 */
public interface MessageService {

    public Message findById(int id);

    public List<Message> findAll();

    public List<Message> findByTopic(String topic);

    public void save (Message message);

    public void remove(int id);
}
