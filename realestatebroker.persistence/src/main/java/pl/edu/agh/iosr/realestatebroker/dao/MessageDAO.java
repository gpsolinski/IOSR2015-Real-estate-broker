package pl.edu.agh.iosr.realestatebroker.dao;

import pl.edu.agh.iosr.realestatebroker.model.Message;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public interface MessageDAO {

    public Message getMessage(long id);

    public List<Message> findMessage();

    public List<Message> findMessage(String key);

    public void saveMessage(Message message);

    public void removeMessage(long id);
}
