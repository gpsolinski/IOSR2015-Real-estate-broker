package pl.edu.agh.iosr.realestatebroker.dao;

import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

/**
 * Created by dpjar_000 on 2015-04-28.
 */
public interface UserDAO {

    public User getUser (long id);

    public List<User> findUser();

    public List<User> findUser(String key);

    public void saveUser (User usee);

    public void removeUser(long id);
}
