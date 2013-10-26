package org.debz.service;

import org.debz.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: tarus
 * Date: 9/16/13
 * Time: 12:55 PM
 */

@Transactional
public interface UserService {

    public User saveUser(User user);
    public void updateUser(User user);
    public User getUser(long id);
    public void deleteUser(int id);
    public List<User> getUsers();
    public List<User> getUsers(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countUsers();



}
