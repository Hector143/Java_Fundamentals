package OOP_GUI;

import java.io.*;
import java.util.*;

public class EmployeeManager {

    private final String FILE_NAME = "employees1.txt";

    // Add Employee
    public boolean addEmployee(Employee emp) throws IOException {
        if (isDuplicate(emp.getEmployeeID())) {
            return false;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(emp.toString());
        bw.newLine();
        bw.close();
        return true;
    }

    // Check Duplicate ID
    private boolean isDuplicate(String id) throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return false;

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|");
            if (data[0].equals(id)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() throws IOException {
        List<Employee> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|");
            list.add(new Employee(
                    data[0], data[1], data[2], data[3], data[4]
            ));
        }
        br.close();
        return list;
    }

    // Update Employee
    public boolean updateEmployee(String id, String newDept, String newPos) throws IOException {
        List<Employee> list = getAllEmployees();
        boolean found = false;

        for (Employee emp : list) {
            if (emp.getEmployeeID().equals(id)) {
                emp.setDepartment(newDept);
                emp.setPosition(newPos);
                found = true;
            }
        }

        if (found) rewriteFile(list);
        return found;
    }

    // Search Employee
    public Employee searchEmployee(String id) throws IOException {
        List<Employee> list = getAllEmployees();
        for (Employee emp : list) {
            if (emp.getEmployeeID().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // Deactivate Employee
    public boolean deactivateEmployee(String id) throws IOException {
        List<Employee> list = getAllEmployees();
        boolean found = false;

        for (Employee emp : list) {
            if (emp.getEmployeeID().equals(id)) {
                emp.setStatus("Inactive");
                found = true;
            }
        }

        if (found) rewriteFile(list);
        return found;
    }

    // Rewrite File
    private void rewriteFile(List<Employee> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Employee emp : list) {
            bw.write(emp.toString());
            bw.newLine();
        }
        bw.close();
    }
}