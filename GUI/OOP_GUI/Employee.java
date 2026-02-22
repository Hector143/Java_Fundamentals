package OOP_GUI;

public class Employee {
    private String employeeID;
    private String employeeName;
    private String department;
    private String position;
    private String status;

    // Constructor
    public Employee(String employeeID, String employeeName,
                    String department, String position, String status) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.position = position;
        this.status = status;
    }

    // Getters and Setters
    public String getEmployeeID() { return employeeID; }
    public String getEmployeeName() { return employeeName; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    public String getStatus() { return status; }

    public void setDepartment(String department) { this.department = department; }
    public void setPosition(String position) { this.position = position; }
    public void setStatus(String status) { this.status = status; }

    // Convert object to file format
    @Override
    public String toString() {
        return employeeID + "|" + employeeName + "|" +
               department + "|" + position + "|" + status;
    }
}