package OOP_GUI;

//Swing Components
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//Table Model
import javax.swing.table.DefaultTableModel;

//AWT Layout & Events
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//File Handling
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

//Collections
import java.util.ArrayList;

public class StudentEnrollmentSystem extends JFrame implements ActionListener {

    // ===============================
    // Student Class (Encapsulation)
    // ===============================
    static class Student {
        private String id;
        private String name;
        private String course;
        private int yearLevel;
        private String status;

        public Student(String id, String name, String course, int yearLevel, String status) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.yearLevel = yearLevel;
            this.status = status;
        }
        
        //getters
        public String getId() { return id; }
        public String getName() { return name; }
        public String getCourse() { return course; }
        public int getYearLevel() { return yearLevel; }
        public String getStatus() { return status; }
        
        //setters
        public void setCourse(String course) { this.course = course; }
        public void setStatus(String status) { this.status = status; }

        // Convert object to file format
        public String toFileString() {
            return id + "|" + name + "|" + course + "|" + yearLevel + "|" + status;
        }
    }

    // ===============================
    // GUI Components
    // ===============================
    private JTextField txtId, txtName, txtCourse, txtYear;
    private JButton btnAdd, btnSearch, btnUpdate, btnDeactivate, btnView;

    private JTable table;
    private DefaultTableModel model;

    private ArrayList<Student> studentList = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    // ===============================
    // Constructor
    // ===============================
    public StudentEnrollmentSystem() {

        setTitle("Student Enrollment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // ===== INPUT PANEL =====
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(new EmptyBorder(20,20,20,20));
        
        inputPanel.add(new JLabel("Student ID:"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Full Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Course:"));
        txtCourse = new JTextField();
        inputPanel.add(txtCourse);

        inputPanel.add(new JLabel("Year Level (1-4):"));
        txtYear = new JTextField();
        inputPanel.add(txtYear);

        add(inputPanel, BorderLayout.NORTH);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        buttonPanel.setBorder(new EmptyBorder(20,20,20,20));
        
        btnAdd = new JButton("Add");
        btnSearch = new JButton("Search");
        btnUpdate = new JButton("Update Course");
        btnDeactivate = new JButton("Deactivate");
        btnView = new JButton("View All");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDeactivate);
        buttonPanel.add(btnView);

        add(buttonPanel, BorderLayout.SOUTH);

        // ===== TABLE =====
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{
                "Student ID", "Name", "Course", "Year", "Status"
        });

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ===== EVENT LISTENERS =====
        btnAdd.addActionListener(this);
        btnSearch.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDeactivate.addActionListener(this);
        btnView.addActionListener(this);

        // Load data from file
        loadFromFile();
        refreshTable();
    }

    // ===============================
    // EVENT HANDLING
    // ===============================
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) addStudent();
        if (e.getSource() == btnSearch) searchStudent();
        if (e.getSource() == btnUpdate) updateStudent();
        if (e.getSource() == btnDeactivate) deactivateStudent();
        if (e.getSource() == btnView) refreshTable();
    }

    // ===============================
    // ADD STUDENT
    // ===============================
    private void addStudent() {
        try {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            String course = txtCourse.getText().trim();
            int year = Integer.parseInt(txtYear.getText().trim());

            if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields required.");
                return;
            }

            if (year < 1 || year > 4) {
                JOptionPane.showMessageDialog(this, "Year must be 1-4.");
                return;
            }

            for (Student s : studentList) {
                if (s.getId().equals(id)) {
                    JOptionPane.showMessageDialog(this, "Duplicate Student ID.");
                    return;
                }
            }

            Student student = new Student(id, name, course, year, "Active");
            studentList.add(student);

            saveToFile();
            refreshTable();
            clearFields();

            JOptionPane.showMessageDialog(this, "Student added.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Year must be a number.");
        }
    }

    // ===============================
    // SEARCH
    // ===============================
    private void searchStudent() {
        String id = txtId.getText().trim();

        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                JOptionPane.showMessageDialog(this,
                        "Found:\nName: " + s.getName() +
                                "\nCourse: " + s.getCourse() +
                                "\nYear: " + s.getYearLevel() +
                                "\nStatus: " + s.getStatus());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student not found.");
    }

    // ===============================
    // UPDATE
    // ===============================
    private void updateStudent() {
        String id = txtId.getText().trim();
        String newCourse = txtCourse.getText().trim();

        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                s.setCourse(newCourse);
                saveToFile();
                refreshTable();
                JOptionPane.showMessageDialog(this, "Course updated.");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student not found.");
    }

    // ===============================
    // DEACTIVATE
    // ===============================
    private void deactivateStudent() {
        String id = txtId.getText().trim();

        for (Student s : studentList) {
            if (s.getId().equals(id)) {

                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Deactivate this student?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    s.setStatus("Inactive");
                    saveToFile();
                    refreshTable();
                    JOptionPane.showMessageDialog(this, "Student deactivated.");
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student not found.");
    }

    // ===============================
    // REFRESH TABLE
    // ===============================
    private void refreshTable() {
        model.setRowCount(0); // clear table

        for (Student s : studentList) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getCourse(),
                    s.getYearLevel(),
                    s.getStatus()
            });
        }
    }

    // ===============================
    // FILE HANDLING
    // ===============================
    private void saveToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            for (Student s : studentList) {
                writer.write(s.toFileString() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file.");
        }
    }

    private void loadFromFile() {

        /*
         BufferedReader vs Scanner Explanation:

         BufferedReader:
         - Reads file line-by-line.
         - Faster for reading large text files.
         - Does NOT automatically convert to int/double.
         - Good for structured records like: ID|Name|Course|Year|Status

         Scanner:
         - Easier to use.
         - Can directly read int, double.
         - Slightly slower than BufferedReader.

         Since we are reading structured lines, BufferedReader is more efficient here.
        */

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

                Student s = new Student(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]
                );

                studentList.add(s);
            }

            reader.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading file.");
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtCourse.setText("");
        txtYear.setText("");
    }

    // ===============================
    // MAIN METHOD
    // ===============================
    public static void main(String[] args) {
        new StudentEnrollmentSystem().setVisible(true);
    }
}

