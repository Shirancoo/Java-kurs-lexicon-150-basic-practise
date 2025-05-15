package todo;

import java.time.LocalDateTime;

public class MainApp {
    public static void main(String[] args) {
        PersonDAO personDAO = new JdbcPersonDAO();
        TodoItemDAO todoDAO = new JdbcTodoItemDAO();

        TodoService service = new TodoService(todoDAO);


        Person p = new Person(1, "Markus", "Markus@gmail.com");
        personDAO.create(p);

        TodoItem item = new TodoItem(1, "Koda java program", LocalDateTime.now().plusDays(1), true, p);
        service.addItem(item);

        for (TodoItem i : service.getOverdueItems()) {
            System.out.println(i.getDescription() + " är försenad!");
        }

        System.out.println(p);
    }
}
