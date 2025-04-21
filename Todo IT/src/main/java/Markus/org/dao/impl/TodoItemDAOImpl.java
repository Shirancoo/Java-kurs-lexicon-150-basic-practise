package Markus.org.dao.impl;

import Markus.dao.TodoItemDAO;
import Markus.org.Person;
import Markus.org.Todoitem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemDAOImpl implements TodoItemDAO {
    private List<Todoitem> items = new ArrayList<>();

    @Override
    public void persist(Todoitem item) {
        items.add(item);
    }

    @Override
    public Todoitem findById(int id) {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Todoitem> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public List<Todoitem> findAllByDoneStatus(boolean done) {
        return items.stream()
                .filter(i -> i.isDone() == done)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todoitem> findByTitleContains(String fragment) {
        return items.stream()
                .filter(i -> i.getTitle().contains(fragment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todoitem> findByPersonId(int personId) {
        return items.stream()
                .filter(i -> i.getCreator().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todoitem> findByDeadlineBefore(LocalDate date) {
        return items.stream()
                .filter(i -> i.getDeadLine().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todoitem> findByDeadlineAfter(LocalDate date) {
        return items.stream()
                .filter(i -> i.getDeadLine().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Todoitem item) {
        items.remove(item);
    }

    @Override
    public List<Todoitem> findByAssignee(Person kalle) {
        return List.of();
    }
}
