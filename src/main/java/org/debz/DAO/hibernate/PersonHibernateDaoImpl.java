package org.debz.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.PersonDAO;
import org.debz.model.Person;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * implementation class for Person dao
 */
@Repository
public class PersonHibernateDaoImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionfactory;

    private Log log = LogFactory.getLog(this.getClass());

    @Transactional
    @Override
    public Person savePerson(Person person) {
        sessionfactory.getCurrentSession().saveOrUpdate(person);
        log.info("Person saved successfully");
        return person;
    }

    @Transactional
    @Override
    public Person getPersonById(Integer pid) {
        log.info("Trying to get  number of persons ");
        return (Person)sessionfactory.getCurrentSession().get(Person.class,pid);
    }

    @Transactional
    @Override
    public List<Person> getPersonsList() {
        log.info("Trying to get  number of persons ");
        Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Person.class);
         log.info("Got this number of persons "+ criteria.list().size());
        criteria.addOrder(Order.asc("names"));
        return criteria.list();
    }
}
