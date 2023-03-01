package person;

import java.time.LocalDate;

public class Customer extends Person implements Billable{

    private int custId;

    private boolean pets;
    private boolean billable;
    private boolean emailAlerts;
    private LocalDate firstDayAsCustomer;

    public Customer(String firstName, String lastName, String streetAddress,
                    String zipcode, String phoneNumber, String emailAddress, int custId, boolean pets, boolean emailAlerts){
        super(firstName, lastName, streetAddress, zipcode,
                phoneNumber,emailAddress);
        this.emailAlerts = emailAlerts;
        this.custId = custId;
        this.pets = pets;
        firstDayAsCustomer = LocalDate.now();
    }


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean isEmailAlerts() {
        return emailAlerts;
    }

    public void setEmailAlerts(boolean emailAlerts) {
        this.emailAlerts = emailAlerts;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public LocalDate getFirstDayAsCustomer() {
        return firstDayAsCustomer;
    }

    public void setFirstDayAsCustomer(LocalDate firstDayAsCustomer) {
        this.firstDayAsCustomer = firstDayAsCustomer;
    }
}
