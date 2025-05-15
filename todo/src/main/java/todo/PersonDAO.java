package todo;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    Person create(Person person);

    Optional<Person> findById(int id);

    List<Person> findAll();

    Person update(Person person);

    void delete(int id);
}
