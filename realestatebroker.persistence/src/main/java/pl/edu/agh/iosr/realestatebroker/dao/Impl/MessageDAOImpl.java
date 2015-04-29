package pl.edu.agh.iosr.realestatebroker.dao.Impl;

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
    private final static String findMessageByReference = "select i from message as i where i.messageRef = :ref";
    private final static String findMessage = "select i from message as i";

    public void setSessionFactory (SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }
    @Override
    public Message getMessage(long id) {
        return (Message) this.sessionFactory.getCurrentSession().get(Message.class, id);
    }

    @Override
    public List<Message> findMessage() throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery(findMessage);
        List<Message> list = query.list();
        return list;
    }

    @Override
    public List<Message> findMessage(String key) throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery(findMessageByReference);
        query.setString("ref", key);
        List<Message> list = query.list();

        return list;
    }

    @Override
    public void saveMessage(Message message) {
        SessionImpl session = (SessionImpl) this.sessionFactory.getCurrentSession();
        this.sessionFactory.getCurrentSession().saveOrUpdate(Message);
    }

    @Override
    public void removeMessage(long id) {
        Object record = this.sessionFactory.getCurrentSession().load(Message.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
