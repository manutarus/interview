package org.debz.service.impl;

import org.debz.DAO.UserDAO;
import org.debz.model.User;
import org.debz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: tarus
 * Date: 9/16/13
 * Time: 12:59 PM
 */

@Transactional

public class UserServiceImpl implements UserService {
    
    @Autowired
    public UserDAO userDAO;

    public User saveUser(User user) {
        return userDAO.saveUser(user);

    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    public List<User> getUsers(final String search, final Integer pageNumber, final Integer pageSize) {
        return userDAO.getUsers(search, pageNumber, pageSize);
    }

    public Number countUsers() {
        return userDAO.countUsers();
    }
    
}
