package GUI_Projects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class EmployeeGUI extends JFrame {

    JTextField txtId, txtName, txtDept, txtPosition;
    JTable table;
    DefaultTableModel model;

    String fileName = "employees.txt";

    public EmployeeGUI() {

        setTitle("Employee System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== INPUT PANEL =====
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Department:"));
        txtDept = new JTextField();
        panel.add(txtDept);

        panel.add(new JLabel("Position:"));
        txtPosition = new JTextField();
        panel.add(txtPosition);

        JButton btnAdd = new JButton("Add");
        JButton btnView = new JButton("View");

        panel.add(btnAdd);
        panel.add(btnView);

        add(panel, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                "ID", "Name", "Department", "Position"
        });

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewEmployees();
            }
        });
    }

    // ==========================
    // ADD EMPLOYEE
    // ==========================
    public void addEmployee() {

        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write(
                    txtId.getText() + "|" +
                    txtName.getText() + "|" +
                    txtDept.getText() + "|" +
                    txtPosition.getText() + "\n"
            );

            writer.close();

            JOptionPane.showMessageDialog(this, "Saved!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // VIEW EMPLOYEES
    // ==========================
    public void viewEmployees() {

        model.setRowCount(0); // clear table first

        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] data = line.split("\\|");

                model.addRow(data);
            }

            scanner.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    public static void main(String[] args) {
        new EmployeeGUI().setVisible(true);
    }
}