package todo;

import java.util.List;
import java.util.Optional;

public interface TodoItemDAO {
    TodoItem create(TodoItem item);

    Optional<TodoItem> findById(int id);

    List<TodoItem> findAll();

    List<TodoItem> findByStatus(Status status);

    TodoItem update(TodoItem item);

    void delete(int id);
}
