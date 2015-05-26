package pl.edu.agh.iosr.realestatebroker.service;

import pl.edu.agh.iosr.realestatebroker.model.User;

import java.util.List;

/**
 * Created by selmerin on 26.05.15.
 */
public interface UserService {

    public User findById(int id);

    public List<User> findAll();

    public List<User> findByLogin(String login);

    public void save (User user);

    public void remove(int id);
}
