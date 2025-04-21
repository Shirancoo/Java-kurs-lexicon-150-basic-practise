package Markus.org.dao.impl;

import Markus.dao.PersonDAO;
import Markus.org.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private List<Person> people = new ArrayList<>();

    @Override
    public void persist(Person person) {
        people.add(person);
    }

    @Override
    public Person findById(int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person findByEmail(String email) {
        return people.stream()
                .filter(p -> p.geteMail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    @Override
    public void remove(Person person) {
        people.remove(person);
    }
}
