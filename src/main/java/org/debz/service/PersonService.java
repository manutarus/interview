package org.debz.service;

import org.debz.model.Person;

import java.util.List;

/**
 * service class for Person class
 */
public interface PersonService {

    public Person savePerson(Person person);
    public Person getPersonById(Integer pid);
    public List<Person> getPersonsList();

}
