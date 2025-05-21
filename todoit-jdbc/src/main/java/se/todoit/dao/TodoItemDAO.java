package se.todoit.dao;

import se.todoit.model.TodoItem;

import java.util.List;

public interface TodoItemDAO {
    TodoItem findById(int itemId);

    List<TodoItem> findAll();

    TodoItem create(TodoItem todoItem);

    boolean deleteById(int itemId);
}
