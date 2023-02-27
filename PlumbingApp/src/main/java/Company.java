
import person.Employee;
import person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {

    private Map<Integer, Employee> employees;

    public Company(){
        employees = new HashMap<>();
    }

    public void addEmployee(Integer id, Employee employee) {
            this.employees.put(id, employee);
    }

    public Employee getEmployee(int employeeID) {
        return null;
    }
}
