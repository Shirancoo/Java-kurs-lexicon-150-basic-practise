package Markus.dao;

import Markus.org.TodoitemTask;

import java.util.List;

public interface TodoItemTaskDAO {
    void persist(TodoitemTask task);

    TodoitemTask findById(int id);

    List<TodoitemTask> findAll();

    List<TodoitemTask> findByAssignedStatus(boolean assigned);

    List<TodoitemTask> findByPersonId(int personId);

    void remove(TodoitemTask task);
}
