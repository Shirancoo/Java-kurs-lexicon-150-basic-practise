package todo;

import java.util.List;
import java.util.Optional;

public class JdbcPersonDAO implements PersonDAO {


    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Optional<Person> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public void delete(int id) {
    }
}
