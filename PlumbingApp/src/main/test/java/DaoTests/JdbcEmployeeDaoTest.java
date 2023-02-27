package DaoTests;

import dao.JdbcEmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import person.Employee;

import java.time.LocalDate;

public class JdbcEmployeeDaoTest extends BaseDaoTest {
    private static final Employee EMPLOYEE_1 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147777777", "abc123@gmail.com", LocalDate.now(), LocalDate.of(1992,04,04));

    private static final Employee EMPLOYEE_2 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147767777", "abc109@gmail.com", LocalDate.now(), LocalDate.of(2001,12,01));

    private static final Employee EMPLOYEE_3 = new Employee("Kyle", "Flinner", "123 rainbow",
            "43223", "6147777767", "abc456@gmail.com", LocalDate.now(), LocalDate.of(1890,05,20));

    private Employee testEmploy;

    private JdbcEmployeeDao sut;

    @Before
    public void setup() {
        sut = new JdbcEmployeeDao(dataSource);
        testEmploy = new Employee("Test", "testy", "another test","still",
                "61472626262", "test@test.com", LocalDate.now(), LocalDate.of(1950,01,28));
    }

    @Test
    public void createEmployee_creates_matching_employee() {
        //TODO create an employee
        testEmploy = sut.createEmployee(EMPLOYEE_1);
        EMPLOYEE_1.setEmployID(testEmploy.getEmployID());
        assertEmployeesMatch("The employees do not match", EMPLOYEE_1, testEmploy);
    }

    public void assertEmployeesMatch(String message, Employee expected, Employee actual){
        Assert.assertEquals(expected.getEmployID(), actual.getEmployID());
        Assert.assertEquals(expected.getDateOfBirth(), actual.getDateOfBirth());
        Assert.assertEquals(expected.getStartDate(), actual.getStartDate());
        Assert.assertEquals(expected.getEmailAddress(), actual.getEmailAddress());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
        Assert.assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        Assert.assertEquals(expected.getZipcode(), actual.getZipcode());
        Assert.assertEquals(expected.getStreetAddress(), actual.getStreetAddress());
    }
}
