package pl.edu.agh.iosr.realestatebroker.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pl.edu.agh.iosr.realestatebroker.dao.UserDAO;
import pl.edu.agh.iosr.realestatebroker.model.User;
import pl.edu.agh.iosr.realestatebroker.service.UserService;

import java.util.List;

/**
 * Created by selmerin on 26.05.15.
 */
public class UserServiceImpl implements UserService{

    private static final transient Log LOG = LogFactory.getLog(UserServiceImpl.class);
    private UserDAO userDAO;

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<User> findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void remove(int id) {
        userDAO.remove(id);
    }
}
