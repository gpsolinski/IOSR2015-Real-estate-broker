package pl.edu.agh.iosr.realestatebroker.dao;

import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public interface UserDAO {

    public User findById (int id);

    public List<User> findAll();

    public List<User> findByLogin(String login);

    public void save (User user);

    public void remove(int id);
}
