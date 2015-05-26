package pl.edu.agh.iosr.realestatebroker.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.MessageDAO;
import pl.edu.agh.iosr.realestatebroker.model.Message;
import pl.edu.agh.iosr.realestatebroker.service.MessageService;

import java.util.List;

/**
 * Created by selmerin on 26.05.15.
 */
public class MessageServiceImpl implements MessageService {

    private static final transient Log LOG = LogFactory.getLog(MessageServiceImpl.class);
    private MessageDAO messageDAO;

    @Override
    public Message findById(int id) {
        return messageDAO.findById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageDAO.findAll();
    }

    @Override
    public List<Message> findByTopic(String topic) {
        return messageDAO.findByTopic(topic);
    }

    @Override
    public void save(Message message) {
        messageDAO.save(message);
    }

    @Override
    public void remove(int id) {
        messageDAO.remove(id);
    }
}
