package Markus.dao;

import Markus.org.Person;
import Markus.org.Todoitem;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemDAO {
    void persist(Todoitem item);

    Todoitem findById(int id);

    List<Todoitem> findAll();

    List<Todoitem> findAllByDoneStatus(boolean done);

    List<Todoitem> findByTitleContains(String fragment);

    List<Todoitem> findByPersonId(int personId);

    List<Todoitem> findByDeadlineBefore(LocalDate date);

    List<Todoitem> findByDeadlineAfter(LocalDate date);

    void remove(Todoitem item);

    List<Todoitem> findByAssignee(Person kalle);
}
