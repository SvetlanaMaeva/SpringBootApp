package edu.springboot.SpringBootApp.service;



import edu.springboot.SpringBootApp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public interface UserService {
    void add(User user);
    void delete(Long id);
    void update(Long id, User user);
    User getUser(Long id);
    List<User> listUsers();

}
