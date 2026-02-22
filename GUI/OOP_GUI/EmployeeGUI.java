package OOP_GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class EmployeeGUI extends JFrame {

    private JTextField txtID, txtName, txtDept, txtPos;
    private JTable table;
    private DefaultTableModel model;
    private EmployeeManager manager;

    public EmployeeGUI() {

        manager = new EmployeeManager();

        setTitle("Employee Management System");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== INPUT PANEL =====
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(new EmptyBorder(20,20,20,20));
        inputPanel.add(new JLabel("Employee ID:"));
        txtID = new JTextField();
        inputPanel.add(txtID);

        inputPanel.add(new JLabel("Employee Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Department:"));
        txtDept = new JTextField();
        inputPanel.add(txtDept);

        inputPanel.add(new JLabel("Position:"));
        txtPos = new JTextField();
        inputPanel.add(txtPos);

        add(inputPanel, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new String[]{"Employee ID", "Name", "Department", "Position", "Status"}
        );

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new EmptyBorder(20,20,20,20));
        add(scrollPane, BorderLayout.CENTER);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(20,20,20,20));
        JButton btnAdd = new JButton("Add");
        JButton btnView = new JButton("View");
        JButton btnUpdate = new JButton("Update");
        JButton btnSearch = new JButton("Search");
        JButton btnDeactivate = new JButton("Deactivate");
        JButton btnClear = new JButton("Clear");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnView);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnDeactivate);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        // ===== BUTTON ACTIONS =====

        // ADD
        btnAdd.addActionListener(e -> {
            try {

                if (txtID.getText().isEmpty() ||
                        txtName.getText().isEmpty() ||
                        txtDept.getText().isEmpty() ||
                        txtPos.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "All fields are required!");
                    return;
                }

                Employee emp = new Employee(
                        txtID.getText(),
                        txtName.getText(),
                        txtDept.getText(),
                        txtPos.getText(),
                        "Active"
                );

                if (manager.addEmployee(emp)) {
                    JOptionPane.showMessageDialog(this,
                            "Employee Added Successfully!");
                    loadTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Duplicate Employee ID!");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File Error!");
            }
        });

        // VIEW
        btnView.addActionListener(e -> loadTable());

        // UPDATE
        btnUpdate.addActionListener(e -> {
            try {

                if (manager.updateEmployee(
                        txtID.getText(),
                        txtDept.getText(),
                        txtPos.getText())) {

                    JOptionPane.showMessageDialog(this,
                            "Employee Updated!");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Employee Not Found!");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File Error!");
            }
        });

        // SEARCH
        btnSearch.addActionListener(e -> {
            try {

                Employee emp = manager.searchEmployee(txtID.getText());

                if (emp != null) {
                    txtName.setText(emp.getEmployeeName());
                    txtDept.setText(emp.getDepartment());
                    txtPos.setText(emp.getPosition());
                    JOptionPane.showMessageDialog(this,
                            "Employee Found!");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Employee Not Found!");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File Error!");
            }
        });

        // DEACTIVATE
        btnDeactivate.addActionListener(e -> {
            try {

                if (manager.deactivateEmployee(txtID.getText())) {
                    JOptionPane.showMessageDialog(this,
                            "Employee Deactivated!");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Employee Not Found!");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File Error!");
            }
        });

        // CLEAR
        btnClear.addActionListener(e -> clearFields());

        setVisible(true);
    }

    // ===== LOAD TABLE METHOD =====
    private void loadTable() {
        try {

            model.setRowCount(0); // Clear table

            List<Employee> list = manager.getAllEmployees();

            for (Employee emp : list) {
                model.addRow(new Object[]{
                        emp.getEmployeeID(),
                        emp.getEmployeeName(),
                        emp.getDepartment(),
                        emp.getPosition(),
                        emp.getStatus()
                });
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "File Error!");
        }
    }

    // ===== CLEAR METHOD =====
    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtDept.setText("");
        txtPos.setText("");
    }

    public static void main(String[] args) {
        new EmployeeGUI();
    }
}
