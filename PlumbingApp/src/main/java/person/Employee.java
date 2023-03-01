package person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person implements Billable, Comparable<Employee> {

    private Integer employID;
    private BigDecimal salary;
    private String department;
    private String position;
    private LocalDate startDate;

    private LocalDate dateOfBirth;

    public Employee(String firstName, String lastName, String streetAddress,
                    String zipcode, String phoneNumber, String emailAddress,
                    LocalDate startDate, LocalDate dateOfBirth) {
        super(firstName, lastName, streetAddress, zipcode,
                phoneNumber, emailAddress);
        this.startDate = startDate;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Employee employee){
        return this.employID - employee.getEmployID();
    }

    @Override
    public String toString() {
        String employee = "ID: " + this.employID + " represents " + super.getFirstName() + " " + super.getLastName();
        return employee;
    }

    public Integer getEmployID() {
        return employID;
    }

    public void setEmployID(Integer employID) {
        this.employID = employID;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String fullName() {
        return getFirstName() + " " + getLastName();
    }
}
