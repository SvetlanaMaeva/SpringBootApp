package edu.springboot.SpringBootApp.dao;




import edu.springboot.SpringBootApp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(Long id);

    void update(Long id, User user);

    User getUser(Long id);

    List<User> listUsers();
}
