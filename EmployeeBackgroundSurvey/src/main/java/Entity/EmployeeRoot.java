package Entity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoot {
    public List<Employee> employees = new ArrayList<>();

    public EmployeeRoot() {
    }

    public EmployeeRoot(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
