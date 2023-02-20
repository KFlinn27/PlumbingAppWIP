package person;

import Task.Assignable;
import Task.Task;

import java.util.ArrayList;
import java.util.List;


public class Person {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String zipcode;
    private String phoneNumber;
    private String emailAddress;
    private boolean hasOpenWorkOrder = false;
    private List<Assignable> openWorkOrders = new ArrayList<>();
    private List<Assignable> closedWorkOrders = new ArrayList<>();

    public Person(){}

    public Person(String firstName, String lastName, String streetAddress,
                  String zipcode, String phoneNumber, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void addWorkOrder(Task workOrder){
        openWorkOrders.add(workOrder);
        hasOpenWorkOrder = true;
    }

    public void closeWorkOrder(Task workOrder){
        openWorkOrders.remove(workOrder);
        closedWorkOrders.add(workOrder);
        if(openWorkOrders.size() > 0){
            hasOpenWorkOrder = false;
        }
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

    public boolean isHasOpenWorkOrder() {
        return hasOpenWorkOrder;
    }

    public void setHasOpenWorkOrder(boolean hasOpenWorkOrder) {
        this.hasOpenWorkOrder = hasOpenWorkOrder;
    }

    public List<Assignable> getOpenWorkOrders() {
        return openWorkOrders;
    }

    public void setOpenWorkOrders(List<Assignable> openWorkOrders) {
        this.openWorkOrders = openWorkOrders;
    }

    public List<Assignable> getClosedWorkOrders() {
        return closedWorkOrders;
    }

    public void setClosedWorkOrders(List<Assignable> closedWorkOrders) {
        this.closedWorkOrders = closedWorkOrders;
    }
}
