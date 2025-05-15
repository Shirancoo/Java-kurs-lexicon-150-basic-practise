package todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoService {
    private final TodoItemDAO dao;

    public TodoService(TodoItemDAO dao) {
        this.dao = dao;
    }

    public TodoItem addItem(TodoItem item) {
        return dao.create(item);
    }

    public List<TodoItem> getAllItems() {
        return dao.findAll();
    }

    public List<TodoItem> getPendingItems() {
        return dao.findByStatus(Status.PENDING);
    }

    public List<TodoItem> getCompletedItems() {
        return dao.findByStatus(Status.COMPLETED);
    }

    public List<TodoItem> getOverdueItems() {
        return dao.findAll().stream()
                .filter(item -> item.getDueDate().isBefore(java.time.LocalDateTime.now()) && !item.isCompleted())
                .collect(Collectors.toList());
    }
}
