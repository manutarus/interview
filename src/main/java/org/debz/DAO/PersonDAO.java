package org.debz.DAO;

import org.debz.model.Person;

import java.util.List;

/**
 * Dao class for Person Object
 */
public interface PersonDAO {

    public Person savePerson(Person person);
    public Person getPersonById(Integer pid);
    public List<Person> getPersonsList();
}
