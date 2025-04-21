package Markus.dao;

import Markus.org.Person;

import java.util.List;

public interface PersonDAO {
    void persist(Person person);

    Person findById(int id);

    Person findByEmail(String email);

    List<Person> findAll();

    void remove(Person person);
}
