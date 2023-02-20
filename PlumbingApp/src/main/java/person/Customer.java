package person;

import java.time.LocalDate;

public class Customer extends Person implements Billable{

    private String specialNeeds;
    private String pets;
    private boolean billable;
    private LocalDate firstDayAsCustomer;

    Customer(String firstName, String lastName, String streetAddress,
             String zipcode, String phoneNumber, String emailAddress){
        super(firstName, lastName, streetAddress, zipcode,
                phoneNumber,emailAddress);
        firstDayAsCustomer = LocalDate.now();
    }


    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
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
