package se.todoit.app;

import se.todoit.dao.PersonDAO;
import se.todoit.dao.impl.PersonDAOImpl;
import se.todoit.model.Person;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAOImpl();


        Person person = new Person();
        person.setFirstName("jonna");
        person.setLastName("Karlsson");
        person.setBirthDate(LocalDate.of(1992, 3, 15));

        Person savedPerson = personDAO.create(person);
        System.out.println("Sparade person: " + savedPerson.getFirstName() + " " + savedPerson.getLastName());


        List<Person> allPeople = personDAO.findAll();
        System.out.println("Alla personer:");
        for (Person p : allPeople) {
            System.out.println(p.getPersonId() + ": " + p.getFirstName() + " " + p.getLastName());
        }


        int idToFind = savedPerson.getPersonId();
        Person found = personDAO.findById(idToFind);
        if (found != null) {
            System.out.println("Hittade: " + found.getFirstName() + " " + found.getLastName());
        }


       boolean deleted = personDAO.deleteById(idToFind);
        if (deleted) {
            System.out.println("Tog bort personen med ID " + idToFind);
        }

    }
}
