package Markus.org;

import Markus.dao.PersonDAO;
import Markus.dao.TodoItemDAO;
import Markus.org.dao.impl.PersonDAOImpl;
import Markus.org.dao.impl.TodoItemDAOImpl;
import Markus.org.models.AppUser;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Skapa användare och roller
        AppUser userKalle = new AppUser("kalle", "5555", AppRole.ROLE_APP_USER);
        AppUser adminMarkus = new AppUser("Markus", "555", AppRole.ROLE_APP_ADMIN);

        // Skapa personer och koppla credentials
        Person markus = new Person("Markus", "Agersten", "markus@gmail.com");
        markus.setCredentials(adminMarkus);

        Person kalle = new Person("Kalle", "Svensson", "kalle.svensson@gmail.com");
        kalle.setCredentials(userKalle);

        // Skapa DAO-klasser
        PersonDAO personDAO = new PersonDAOImpl(); //
        TodoItemDAO todoDAO = new TodoItemDAOImpl();

        // Lägg till personer
        personDAO.persist(markus);
        personDAO.persist(kalle);

        // Skapa Todoitems
        Todoitem springa = new Todoitem("Springa", "Spring 5 km", LocalDate.of(2025, 5, 17), false, kalle);
        Todoitem plugga = new Todoitem("Plugga", "Plugga Java", LocalDate.of(2025, 5, 20), false, kalle);
        Todoitem koda = new Todoitem("Koda", "Gör todo-app", LocalDate.now(), true, markus);

        // Lägg till uppgifter
        todoDAO.persist(springa);
        todoDAO.persist(plugga);
        todoDAO.persist(koda);

        // Skapa uppgift för task (beroende mellan personer)
        TodoitemTask task = new TodoitemTask(true, springa, markus);

        System.out.println("=== Sammanfattning av uppgift ===");
        System.out.println(task.getSummary());

        System.out.println("\n=== Alla Todo-uppgifter för Kalle ===");
        List<Todoitem> kallesUppgifter = todoDAO.findByAssignee(kalle);
        for (Todoitem uppgift : kallesUppgifter) {
            System.out.println(uppgift);
        }

        System.out.println("\n=== Alla personer ===");
        for (Person p : personDAO.findAll()) {
            System.out.println(p);
        }
    }
}
