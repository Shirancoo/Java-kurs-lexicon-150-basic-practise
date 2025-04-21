package Markus.org.dao.impl;

import Markus.dao.TodoItemTaskDAO;
import Markus.org.TodoitemTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {
    private List<TodoitemTask> tasks = new ArrayList<>();

    @Override
    public void persist(TodoitemTask task) {
        tasks.add(task);
    }

    @Override
    public TodoitemTask findById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TodoitemTask> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<TodoitemTask> findByAssignedStatus(boolean assigned) {
        return tasks.stream()
                .filter(t -> t.isAssigned() == assigned)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoitemTask> findByPersonId(int personId) {
        return tasks.stream()
                .filter(t -> t.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TodoitemTask task) {
        tasks.remove(task);
    }
}
