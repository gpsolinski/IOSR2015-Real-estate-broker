package pl.edu.agh.iosr.realestatebroker.dao;

import pl.edu.agh.iosr.realestatebroker.model.Message;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public interface MessageDAO {

    public Message findById(int id);

    public List<Message> findAll();

    public List<Message> findByTopic(String topic);

    public void save(Message message);

    public void remove(int id);
}
