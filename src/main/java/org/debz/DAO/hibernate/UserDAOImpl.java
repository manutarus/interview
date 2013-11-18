package org.debz.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.UserDAO;
import org.debz.model.User;
import org.debz.utils.BCrypt;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: tarus
 * Date: 9/16/13
 * Time: 12:30 PM
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        log.info("Person saved successfully");
        return user;
    }

    public void updateUser(User user) {
        User userToUpdate = getUser(user.getSid());
        userToUpdate.setEmail(user.getEmail());
        getCurrentSession().update(userToUpdate);

    }

    public User getUser(long id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    @SuppressWarnings("unchecked")
      @Transactional
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
   public List<User> getUsers(final String search, final Integer pageNumber, final Integer pageSize) {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public Number countUsers() {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }

    public User getUserByUsername(String username){

        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

}
