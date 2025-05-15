package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {
    // JDBC‐URL utan schema för första anslutningen:
    private static final String JDBC_BASE = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    // JDBC‐URL mot vår printdb:
    private static final String JDBC_DB   = "jdbc:mysql://localhost:3306/printdb?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER   = "root";          // ändra om du har annan användare
    private static final String DB_PASS   = "ditt_lösenord"; // ange ditt lösenord här

    private Connection conn;
    private DefaultTableModel model;
    private JTable table;
    private JTextField tfName, tfQty, tfPrice, tfCost;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Main().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public Main() throws SQLException {
        // Ladda drivrutin
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) { throw new SQLException("Kunde ej ladda JDBC-drivrutin", e); }

        // 1. Anslut utan schema och skapa printdb om den saknas
        try (Connection c = DriverManager.getConnection(JDBC_BASE, DB_USER, DB_PASS);
             Statement s = c.createStatement())
        {
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS printdb " +
                    "CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci");
        }

        // 2. Anslut mot printdb och skapa tabellen om den saknas
        conn = DriverManager.getConnection(JDBC_DB, DB_USER, DB_PASS);
        try (Statement s = conn.createStatement()) {
            s.executeUpdate("""
                CREATE TABLE IF NOT EXISTS products (
                  id INT AUTO_INCREMENT PRIMARY KEY,
                  name VARCHAR(100) NOT NULL,
                  quantity INT NOT NULL,
                  price DOUBLE NOT NULL,
                  cost DOUBLE NOT NULL
                )
            """);
        }

        // 3. Bygg GUI
        setTitle("3D-Print Produkt­hanterare");
        initUI();
        loadProducts();

        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initUI() {
        model = new DefaultTableModel(new Object[]{
                "ID","Namn","Antal","Pris","Kostnad","Vinst (kr)","Marginal (%)"
        }, 0) {
            @Override public boolean isCellEditable(int r, int c){ return false; }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel pan = new JPanel(new GridLayout(2,1));
        JPanel in = new JPanel();
        tfName  = new JTextField(10);
        tfQty   = new JTextField(5);
        tfPrice = new JTextField(7);
        tfCost  = new JTextField(7);
        in.add(new JLabel("Namn:"));    in.add(tfName);
        in.add(new JLabel("Antal:"));   in.add(tfQty);
        in.add(new JLabel("Pris:"));    in.add(tfPrice);
        in.add(new JLabel("Kostnad:")); in.add(tfCost);
        pan.add(in);

        JPanel btns = new JPanel();
        JButton add = new JButton("Lägg till");
        JButton del = new JButton("Ta bort");
        JButton ref = new JButton("Uppdatera");
        btns.add(add); btns.add(del); btns.add(ref);
        pan.add(btns);

        add(pan, BorderLayout.SOUTH);

        add.addActionListener(e -> { try { addProduct();   } catch (Exception ex) { showError(ex); }});
        del.addActionListener(e -> { try { deleteProduct();} catch (Exception ex) { showError(ex); }});
        ref.addActionListener(e -> { try { loadProducts(); } catch (Exception ex) { showError(ex); }});
    }

    private void addProduct() throws SQLException {
        String name = tfName.getText().trim();
        int qty      = Integer.parseInt(tfQty.getText().trim());
        double price = Double.parseDouble(tfPrice.getText().trim());
        double cost  = Double.parseDouble(tfCost.getText().trim());

        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO products(name,quantity,price,cost) VALUES(?,?,?,?)"))
        {
            ps.setString(1, name);
            ps.setInt(2, qty);
            ps.setDouble(3, price);
            ps.setDouble(4, cost);
            ps.executeUpdate();
        }
        clearInputs();
        loadProducts();
    }

    private void deleteProduct() throws SQLException {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Välj en rad att ta bort.");
            return;
        }
        int id = (int) model.getValueAt(row, 0);
        try (PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM products WHERE id=?"))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        loadProducts();
    }

    private void loadProducts() throws SQLException {
        model.setRowCount(0);
        try (Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM products"))
        {
            while (rs.next()) {
                int    id    = rs.getInt("id");
                String name  = rs.getString("name");
                int    qty   = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double cost  = rs.getDouble("cost");
                double diff  = price - cost;
                double profit= diff * qty;
                double marg  = (diff/cost)*100;
                model.addRow(new Object[]{
                        id, name, qty,
                        String.format("%.2f", price),
                        String.format("%.2f", cost),
                        String.format("%.2f", profit),
                        String.format("%.2f", marg)
                });
            }
        }
    }

    private void clearInputs() {
        tfName.setText("");
        tfQty.setText("");
        tfPrice.setText("");
        tfCost.setText("");
    }

    private void showError(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
    }
}
