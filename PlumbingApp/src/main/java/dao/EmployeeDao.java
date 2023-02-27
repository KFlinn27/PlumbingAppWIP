package dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import person.Employee;

import java.util.List;

public interface EmployeeDao {
    /*
    Returns all employees currently in the database. Only returns first
    name, last name and ID for privacy purposes.
     */
    public List<Employee> getAllEmployees();

    public Employee createEmployee(Employee employee);

    public void deleteAllEmployee();

    public Employee mapEmployeeFromRowSet(SqlRowSet current);
}
