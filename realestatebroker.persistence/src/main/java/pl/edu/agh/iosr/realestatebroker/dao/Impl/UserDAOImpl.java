package pl.edu.agh.iosr.realestatebroker.dao.Impl;

import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.UserDAO;
import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public class UserDAOImpl implements UserDAO {

    private static final transient Log LOG = LogFactory.getLog(UserDAOImpl.class);
    private SessionFactory sessionFactory;
    private Query query = null;
    private final static String findUserByReference = "select i from user as i where userRef = :ref";
    private final static String findUser = "select i from user as i";

    public void setSessionFactory (SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }

    @Override
    public User getUser(long id) {
        return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findUser() throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery (findUser);
        List<User> list = query.list();
        return list;
    }

    @Override
    public List<User> findUser(String key) throws HibernateException {
        query  = this.sessionFactory.getCurrentSession().createQuery (findUserByReference);
        query.setString("ref", key);
        List<User> list = query.list();

        return list;
    }

    @Override
    public void saveUser(User user) {
        SessionImpl session = (SessionImpl) this.sessionFactory.getCurrentSession();
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void removeUser(long id) {
        Object record = this.sessionFactory.getCurrentSession().load(User.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
