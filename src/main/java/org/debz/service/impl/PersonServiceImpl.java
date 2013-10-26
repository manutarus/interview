package org.debz.service.impl;

import org.debz.DAO.PersonDAO;
import org.debz.model.Person;
import org.debz.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * implementation class for PersonService class
 */
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;


    @Override
    public Person savePerson(Person person) {
        return personDAO.savePerson(person);
    }


    @Override
    public Person getPersonById(Integer pid) {
        return personDAO.getPersonById(pid);
    }


    @Override
    public List<Person> getPersonsList() {
        return personDAO.getPersonsList();
    }
}
