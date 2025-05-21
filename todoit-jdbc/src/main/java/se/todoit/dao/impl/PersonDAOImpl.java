package se.todoit.dao.impl;

import se.todoit.dao.PersonDAO;
import se.todoit.model.Person;
import se.todoit.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private Connection connection = DatabaseConnection.getConnection();

    public Person create(Person person) {
        String sql = "INSERT INTO person (first_name, last_name, birth_date) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setDate(3, Date.valueOf(person.getBirthDate()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                person.setPersonId(rs.getInt(1));
            }

            return person;

        } catch (SQLException e) {
            System.out.println("Fel vid skapande av person.");
            e.printStackTrace();
        }

        return null;
    }

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM person";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Person person = new Person();
                person.setPersonId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setBirthDate(rs.getDate("birth_date").toLocalDate());
                people.add(person);
            }

        } catch (SQLException e) {
            System.out.println("Fel vid hämtning av alla personer.");
            e.printStackTrace();
        }

        return people;
    }

    public Person findById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Person person = new Person();
                person.setPersonId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setBirthDate(rs.getDate("birth_date").toLocalDate());
                return person;
            }

        } catch (SQLException e) {
            System.out.println("Fel vid hämtning av person med id " + id);
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Fel vid radering av person med id " + id);
            e.printStackTrace();
        }
        return false;
    }

    public Person update(Person person) {
        String sql = "UPDATE person SET first_name = ?, last_name = ?, birth_date = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setDate(3, Date.valueOf(person.getBirthDate()));
            stmt.setInt(4, person.getPersonId());
            int rows = stmt.executeUpdate();
            if (rows > 0) return person;
        } catch (SQLException e) {
            System.out.println("Fel vid uppdatering av person.");
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> findByName(String name) {
        List<Person> result = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE first_name LIKE ? OR last_name LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setPersonId(rs.getInt("id"));
                p.setFirstName(rs.getString("first_name"));
                p.setLastName(rs.getString("last_name"));
                p.setBirthDate(rs.getDate("birth_date").toLocalDate());
                result.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Fel vid sökning efter namn.");
            e.printStackTrace();
        }
        return result;
    }

}
