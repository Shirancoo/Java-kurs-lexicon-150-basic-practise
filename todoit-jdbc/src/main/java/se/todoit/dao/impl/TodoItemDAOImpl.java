package se.todoit.dao.impl;

import se.todoit.dao.TodoItemDAO;
import se.todoit.model.TodoItem;
import se.todoit.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO {

    private Connection connection = DatabaseConnection.getConnection();

    public TodoItem create(TodoItem item) {
        String sql = "INSERT INTO todo_item (title, description, deadline, is_completed) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getDescription());
            stmt.setDate(3, Date.valueOf(item.getDeadline()));
            stmt.setBoolean(4, item.isCompleted());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                item.setItemId(rs.getInt(1));
            }

            return item;

        } catch (SQLException e) {
            System.out.println("Fel vid skapande av todo-item.");
            e.printStackTrace();
        }

        return null;
    }

    public List<TodoItem> findAll() {
        List<TodoItem> items = new ArrayList<>();
        String sql = "SELECT * FROM todo_item";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TodoItem item = new TodoItem();
                item.setItemId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setDeadline(rs.getDate("deadline").toLocalDate());
                item.setCompleted(rs.getBoolean("is_completed"));
                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println("Fel vid hämtning av alla todo-items.");
            e.printStackTrace();
        }

        return items;
    }

    public TodoItem findById(int id) {
        String sql = "SELECT * FROM todo_item WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TodoItem item = new TodoItem();
                item.setItemId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setDeadline(rs.getDate("deadline").toLocalDate());
                item.setCompleted(rs.getBoolean("is_completed"));
                return item;
            }

        } catch (SQLException e) {
            System.out.println("Fel vid hämtning av todo-item med id " + id);
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM todo_item WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Fel vid radering av todo-item med id " + id);
            e.printStackTrace();
        }

        return false;
    }

    public TodoItem update(TodoItem item) {
        String sql = "UPDATE todo_item SET title = ?, description = ?, deadline = ?, is_completed = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getDescription());
            stmt.setDate(3, Date.valueOf(item.getDeadline()));
            stmt.setBoolean(4, item.isCompleted());
            stmt.setInt(5, item.getItemId());
            int rows = stmt.executeUpdate();
            if (rows > 0) return item;
        } catch (SQLException e) {
            System.out.println("Fel vid uppdatering av todo-item.");
            e.printStackTrace();
        }
        return null;
    }

    public List<TodoItem> findByDoneStatus(boolean isDone) {
        List<TodoItem> result = new ArrayList<>();
        String sql = "SELECT * FROM todo_item WHERE is_completed = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, isDone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TodoItem item = new TodoItem();
                item.setItemId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setDeadline(rs.getDate("deadline").toLocalDate());
                item.setCompleted(rs.getBoolean("is_completed"));
                result.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Fel vid sökning efter status.");
            e.printStackTrace();
        }
        return result;
    }

    public List<TodoItem> findByAssignee(int personId) {
        List<TodoItem> result = new ArrayList<>();
        String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, personId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TodoItem item = new TodoItem();
                item.setItemId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setDeadline(rs.getDate("deadline").toLocalDate());
                item.setCompleted(rs.getBoolean("is_completed"));
                result.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Fel vid sökning efter assignee id.");
            e.printStackTrace();
        }
        return result;
    }

    public List<TodoItem> findByUnassignedTodoItems() {
        List<TodoItem> result = new ArrayList<>();
        String sql = "SELECT * FROM todo_item WHERE assignee_id IS NULL";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TodoItem item = new TodoItem();
                item.setItemId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setDeadline(rs.getDate("deadline").toLocalDate());
                item.setCompleted(rs.getBoolean("is_completed"));
                result.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Fel vid hämtning av oassignade todo-items.");
            e.printStackTrace();
        }
        return result;
    }

}
