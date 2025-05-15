import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Produktregistrering");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        // Inmatningsfält
        JTextField produktField = new JTextField();
        JTextField antalField = new JTextField();
        JTextField prisField = new JTextField();
        JTextField kostnadField = new JTextField();

        // Visningsfält
        JLabel totalPrisLabel = new JLabel("0.0 kr");
        JLabel vinstLabel = new JLabel("0.0 kr");

        // Lägg till komponenter i GUI
        frame.add(new JLabel("Produktnamn:"));
        frame.add(produktField);
        frame.add(new JLabel("Antal:"));
        frame.add(antalField);
        frame.add(new JLabel("Pris per styck:"));
        frame.add(prisField);
        frame.add(new JLabel("Kostnad totalt:"));
        frame.add(kostnadField);
        frame.add(new JLabel("Totalt försäljningsvärde:"));
        frame.add(totalPrisLabel);
        frame.add(new JLabel("Vinst (intäkt - kostnad):"));
        frame.add(vinstLabel);

        JButton sparaKnapp = new JButton("Spara till fil");
        frame.add(new JLabel()); // tomt fält
        frame.add(sparaKnapp);

        // Live-uppdatering
        DocumentListener listener = new DocumentListener() {
            public void update() {
                try {
                    int antal = Integer.parseInt(antalField.getText());
                    double pris = Double.parseDouble(prisField.getText());
                    double kostnad = Double.parseDouble(kostnadField.getText());
                    double totalPris = antal * pris;
                    double vinst = totalPris - kostnad;

                    totalPrisLabel.setText(String.format("%.2f kr", totalPris));
                    vinstLabel.setText(String.format("%.2f kr", vinst));
                } catch (NumberFormatException e) {
                    totalPrisLabel.setText("0.0 kr");
                    vinstLabel.setText("0.0 kr");
                }
            }

            public void insertUpdate(javax.swing.event.DocumentEvent e) { update(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { update(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { update(); }
        };

        antalField.getDocument().addDocumentListener(listener);
        prisField.getDocument().addDocumentListener(listener);
        kostnadField.getDocument().addDocumentListener(listener);

        // Spara-knappens funktion
        sparaKnapp.addActionListener(e -> {
            try {
                String produkt = produktField.getText();
                int antal = Integer.parseInt(antalField.getText());
                double pris = Double.parseDouble(prisField.getText());
                double kostnad = Double.parseDouble(kostnadField.getText());
                double total = antal * pris;
                double vinst = total - kostnad;

                String csv = "Produkt,Antal,Pris per styck,Kostnad,Total,Vinst\n";
                csv += String.format("%s,%d,%.2f,%.2f,%.2f,%.2f\n",
                        produkt, antal, pris, kostnad, total, vinst);

                String path = System.getProperty("user.home") + "\\Documents\\produktdata.csv";
                try (FileWriter writer = new FileWriter(path)) {
                    writer.write(csv);
                    JOptionPane.showMessageDialog(frame, "Sparat till:\n" + path);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Felaktig inmatning.");
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
