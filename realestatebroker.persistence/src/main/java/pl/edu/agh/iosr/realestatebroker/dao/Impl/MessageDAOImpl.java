package pl.edu.agh.iosr.realestatebroker.dao.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import pl.edu.agh.iosr.realestatebroker.dao.MessageDAO;
import pl.edu.agh.iosr.realestatebroker.model.Message;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-29.
 */
public class MessageDAOImpl implements MessageDAO {

    private static final transient Log LOG = LogFactory.getLog(MessageDAOImpl.class);
    private SessionFactory sessionFactory;
    private Query query = null;
    private final static String findMessageByTopic = "select m from Message as m where m.topic = :ref";
    private final static String findMessage = "select m from Message as m";

    public void setSessionFactory (SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }

    @Override
    public Message findById(int id) {
        return (Message) this.sessionFactory.getCurrentSession().get(Message.class, id);
    }

    @Override
    public List<Message> findAll() throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery(findMessage);
        List<Message> list = query.list();
        return list;
    }

    @Override
    public List<Message> findByTopic(String key) throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery(findMessageByTopic);
        query.setString("ref", key);
        List<Message> list = query.list();

        return list;
    }

    @Override
    public void save(Message message) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(message);
    }

    @Override
    public void remove(int id) {
        Object record = this.sessionFactory.getCurrentSession().load(Message.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
