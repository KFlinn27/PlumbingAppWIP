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
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        //TODO write sql statement required
        String sql = "SELECT ";
        return null;
    }


    @Override
    public Employee createEmployee(Employee employee) {

        String sql = "INSERT INTO employee (first_name, last_name, st_address, zip_code, phone_number, email, date_of_birth," +
                " date_of_hire) VALUES(?, ?, ?, ?, ?, ?, ?, ?) RETURNING employ_id;";
        Integer empID = jdbcTemplate.queryForObject(sql, Integer.class, employee.getFirstName(), employee.getLastName(), employee.getStreetAddress(),
                employee.getZipcode(), employee.getPhoneNumber(), employee.getEmailAddress(), LocalDate.now(), employee.getStartDate());
        employee.setEmployID(empID);
        return employee;

        // TODO: FINISH THIS DUDE HOLY


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
                current.getDate("start_date").toLocalDate(), current.getDate("date_of_birth").toLocalDate());
        employee.setStartDate(startDate);
        return employee;
    }
}
