package person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person implements Billable{

    private BigDecimal salary;
    private String department;
    private String position;
    private LocalDate startDate;

    Employee(String firstName, String lastName, String streetAddress,
             String zipcode, String phoneNumber, String emailAddress,
             boolean startToday){
        super(firstName, lastName, streetAddress, zipcode,
                phoneNumber,emailAddress);
        if(startToday){
            this.startDate = LocalDate.now();
        }
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
}
