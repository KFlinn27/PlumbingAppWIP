package DaoTests;

import dao.JdbcEmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import person.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDaoTest extends BaseDaoTest {
    private static final Employee EMPLOYEE_1 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147777777", "abc123@gmail.com", LocalDate.now(), LocalDate.of(1992,04,04));

    private static final Employee EMPLOYEE_2 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147767777", "abc109@gmail.com", LocalDate.now(), LocalDate.of(2001,12,01));

    private static final Employee EMPLOYEE_3 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147777767", "abc456@gmail.com", LocalDate.of(2020,01,01), LocalDate.of(1890,05,20));

    private Employee testEmploy;

    private JdbcEmployeeDao sut;

    @Before
    public void setup() {
        sut = new JdbcEmployeeDao(dataSource);
        testEmploy = new Employee("Test", "testy", "another test","still",
                "61472626262", "test@test.com", LocalDate.now(), LocalDate.of(1950,01,28));
        EMPLOYEE_1.setEmployID(1);
        EMPLOYEE_2.setEmployID(2);
        EMPLOYEE_3.setEmployID(3);
    }

    @Test
    public void getEmployee_returns_correct_employee() {
        assertEmployeesMatch("The employee is not correct", EMPLOYEE_1, sut.getEmployee(1));
        assertEmployeesMatch("The employee is not correct", EMPLOYEE_2, sut.getEmployee(2));
    }

    @Test
    public void getEmployee_returns_null_for_nonexistant_id(){
        Assert.assertNull(sut.getEmployee(0));
        Assert.assertNull(sut.getEmployee(5));
    }

    @Test
    public void createEmployee_creates_matching_employee() {
        Employee tester3 = sut.createEmployee(testEmploy);
        testEmploy.setEmployID(tester3.getEmployID());
        assertEmployeesMatch("The employees do not match", testEmploy, tester3);
    }
    @Test
    public void createEmployee_creates_matching_employee_and_value_matches_when_retrieved() {
        Employee tester3 = sut.createEmployee(testEmploy);
        testEmploy.setEmployID(tester3.getEmployID());
        assertEmployeesMatch("The employees do not match", testEmploy, sut.getEmployee(testEmploy.getEmployID()));
    }


    @Test
    public void getAllEmployees_returns_list_of_3_employees(){
        List<Employee> test = sut.getAllEmployees();
        Assert.assertEquals(test.size(), 3);
        assertEmployeesMatch("Employee does not match list expected index", EMPLOYEE_1, test.get(0));
        assertEmployeesMatch("Employee does not match list expected index", EMPLOYEE_2, test.get(1));
        assertEmployeesMatch("Employee does not match list expected index", EMPLOYEE_3, test.get(2));

    }

    @Test
    public void getEmployeeAnniversaries_returns_2_employees(){
        List<Employee> test = sut.getEmployeeAnniversaries();
        Assert.assertEquals(test.size(),2 );
        assertEmployeesMatch("Employee does not match list expected index", EMPLOYEE_1, test.get(0));
        assertEmployeesMatch("Employee does not match list expected index", EMPLOYEE_2, test.get(1));
    }

    @Test
    public void updateEmployee_updates_employee_properly() {
        Employee employee = new Employee("Test", "testy", "another test","still",
                "61472626262", "test@test.com", LocalDate.now().minusDays(1), LocalDate.of(1950,01,28));
        employee.setEmployID(1);
        sut.updateEmployee(employee);
        assertEmployeesMatch("The employee did not update properly.", employee, sut.getEmployee(1));
    }

    public void assertEmployeesMatch(String message, Employee expected, Employee actual){
        Assert.assertEquals(message, expected.getEmployID(), actual.getEmployID());
        Assert.assertEquals(message, expected.getDateOfBirth(), actual.getDateOfBirth());
        Assert.assertEquals(message, expected.getStartDate(), actual.getStartDate());
        Assert.assertEquals(message, expected.getEmailAddress(), actual.getEmailAddress());
        Assert.assertEquals(message, expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(message, expected.getLastName(), actual.getLastName());
        Assert.assertEquals(message, expected.getPhoneNumber(), actual.getPhoneNumber());
        Assert.assertEquals(message, expected.getZipcode(), actual.getZipcode());
        Assert.assertEquals(message, expected.getStreetAddress(), actual.getStreetAddress());
    }
}
