package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import person.Employee;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getEmployee(int id){
        Employee employee = null;
        String sql = "SELECT employ_id, first_name, last_name, st_address, zip_code, phone_number, email, date_of_birth, date_of_hire " +
                "From employee where employ_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
           employee = mapEmployeeFromRowSet(results);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT employ_id, first_name, last_name, st_address, zip_code, phone_number, email, date_of_birth, date_of_hire " +
            "From employee";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            employees.add(mapEmployeeFromRowSet(results));
        }
        return employees;
    }


    @Override
    public Employee createEmployee(Employee employee) {

        String sql = "INSERT INTO employee (first_name, last_name, st_address, zip_code, phone_number, email, date_of_birth," +
                " date_of_hire) VALUES(?, ?, ?, ?, ?, ?, ?, ?) RETURNING employ_id;";
        Integer empID = jdbcTemplate.queryForObject(sql, Integer.class, employee.getFirstName(), employee.getLastName(), employee.getStreetAddress(),
                employee.getZipcode(), employee.getPhoneNumber(), employee.getEmailAddress(), employee.getDateOfBirth(), employee.getStartDate());
        employee.setEmployID(empID);
        return employee;

    }

    public List<Employee> getEmployeeAnniversaries() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT employ_id, first_name, last_name, st_address, zip_code, phone_number, email, date_of_birth, date_of_hire \n" +
                "FROM employee \n" +
                "WHERE EXTRACT(month from date_of_hire) = EXTRACT(month from now()) \n" +
                "ORDER BY date_of_hire ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            employees.add(mapEmployeeFromRowSet(results));
        }
        return employees;
    }

    public void updateEmployee(Employee employee){
        String sql = "UPDATE employee " +
                "SET first_name = ?, last_name = ?, st_address = ?, zip_code = ?, phone_number = ?, email = ?, " +
                "date_of_birth = ?, date_of_hire = ? WHERE employ_id = ?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getStreetAddress(),
                employee.getZipcode(), employee.getPhoneNumber(), employee.getEmailAddress(),
                employee.getDateOfBirth(), employee.getStartDate(), employee.getEmployID());

    }

    @Override
    public void deleteAllEmployee() {
        String sql = "DELETE FROM employee;";
        jdbcTemplate.update(sql);
    }

    @Override
    public Employee mapEmployeeFromRowSet(SqlRowSet current) {
        LocalDate startDate = current.getDate("date_of_hire").toLocalDate();
        Employee employee = new Employee(current.getString("first_name"), current.getString("last_name"), current.getString("st_address"),
                current.getString("zip_code"), current.getString("phone_number"), current.getString("email"),
                current.getDate("date_of_hire").toLocalDate(), current.getDate("date_of_birth").toLocalDate());
        employee.setStartDate(startDate);
        employee.setEmployID(current.getInt("employ_id"));
        return employee;
    }

    public void removeEmployee(int employeeID) {
        String sql = "DELETE FROM employee WHERE employ_id = ?";
        jdbcTemplate.update(sql, employeeID);
    }
}
