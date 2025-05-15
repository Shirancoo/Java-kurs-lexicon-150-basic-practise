package todo;

import java.util.List;
import java.util.Optional;

public class JdbcTodoItemDAO implements TodoItemDAO {


    @Override
    public TodoItem create(TodoItem item) {
        return null;
    }

    @Override
    public Optional<TodoItem> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<TodoItem> findAll() {
        return List.of();
    }

    @Override
    public List<TodoItem> findByStatus(Status status) {
        return List.of();
    }

    @Override
    public TodoItem update(TodoItem item) {
        return null;
    }

    @Override
    public void delete(int id) {
    }
}
