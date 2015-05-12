package pl.edu.agh.iosr.realestatebroker.dao.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
    private final static String findUserByLogin = "select u from User as u where u.login = :ref";
    private final static String findUser = "select u from User as u";

    public void setSessionFactory (SessionFactory _sessionFactory) {
        this.sessionFactory = _sessionFactory;
    }

    @Override
    public User findById(int id) {
        return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() throws HibernateException {
        query = this.sessionFactory.getCurrentSession().createQuery (findUser);
        List<User> list = query.list();
        return list;
    }

    @Override
    public List<User> findByLogin(String login) throws HibernateException {
        query  = this.sessionFactory.getCurrentSession().createQuery (findUserByLogin);
        query.setString("ref", login);
        List<User> list = query.list();

        return list;
    }

    @Override
    public void save(User user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void remove(int id) {
        Object record = this.sessionFactory.getCurrentSession().load(User.class, id);
        this.sessionFactory.getCurrentSession().delete(record);
    }
}
