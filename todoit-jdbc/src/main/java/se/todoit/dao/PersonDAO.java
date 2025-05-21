package se.todoit.dao;

import se.todoit.model.Person;

import java.util.List;

public interface PersonDAO {
    Person findById(int personId);

    List<Person> findAll();

    Person create(Person person);

    boolean deleteById(int personId);
}
