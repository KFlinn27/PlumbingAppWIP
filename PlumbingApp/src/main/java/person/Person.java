package person;

import workorder.Task;
import workorder.WorkOrder;

import java.util.ArrayList;
import java.util.List;


public class Person {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String zipcode;
    private String phoneNumber;
    private String emailAddress;
    private List<WorkOrder> openWorkOrders = new ArrayList<>();
    private List<WorkOrder> closedWorkOrders = new ArrayList<>();

    public Person(){}

    public Person(String firstName, String lastName, String streetAddress,
                  String zipcode, String phoneNumber, String emailAddress){
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public boolean hasOpenWorkOrders(){
        return openWorkOrders.size() > 0;
    }

    public void addWorkOrder(WorkOrder workOrder){
        openWorkOrders.add(workOrder);
    }

    public void closeWorkOrder(WorkOrder workOrder){
        openWorkOrders.remove(workOrder);
        closedWorkOrders.add(workOrder);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<WorkOrder> getOpenWorkOrders() {
        return openWorkOrders;
    }

    public List<WorkOrder> getClosedWorkOrders() {
        return closedWorkOrders;
    }
}
