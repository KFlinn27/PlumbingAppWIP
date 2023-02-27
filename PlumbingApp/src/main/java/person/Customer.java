package person;

import java.time.LocalDate;

public class Customer extends Person implements Billable{

    private boolean pets;
    private boolean billable;
    private LocalDate firstDayAsCustomer;

    Customer(String firstName, String lastName, String streetAddress,
             String zipcode, String phoneNumber, String emailAddress){
        super(firstName, lastName, streetAddress, zipcode,
                phoneNumber,emailAddress);
        firstDayAsCustomer = LocalDate.now();
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
