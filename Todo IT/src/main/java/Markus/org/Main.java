package Markus.org;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AppUser userKalle = new AppUser("kalle", "5555", AppRole.ROLE_APP_USER);
        AppUser adminMarkus = new AppUser("Markus", "555", AppRole.ROLE_APP_ADMIN);
        Person markus = new Person("Markus", "agersten", "markus.agersten@gmail.com");

        markus.setCredentials(adminMarkus);

        Person kalle = new Person("Kalle", "Svensson", "Kalle.svensson@gmail.com");
        kalle.setCredentials(userKalle);



        Todoitem running = new Todoitem("Running", "run 20 miles", LocalDate.of(2025, 5, 17), true, markus);
        TodoitemTask task = new TodoitemTask(true, running, kalle);

        System.out.println(task.getSummary());


    }

}