
import person.Customer;
import person.Employee;
import person.Person;

import java.time.LocalDate;
import java.util.*;

public class Company {

    private TreeMap<Integer, Employee> employees;
    private TreeMap<Integer, Customer> customers;

    public Company(){
        employees = new TreeMap<>();
        customers = new TreeMap<>();
    }

    public void addEmployee(Employee employee) {
            employees.put(employee.getEmployID(), employee);
    }

    public void populateEmployees(List<Employee> allEmployees) {
        for(Employee current : allEmployees){
            addEmployee(current);
        }
    }

    public TreeMap<Integer, Employee> getEmployees() {
        return employees;
    }

    public void removeEmployee(int employeeIdToDelete) {
        employees.remove(employeeIdToDelete);
    }

    public Employee getEmployeeByID(int employeeID) {
        return employees.get(employeeID);
    }

    public void changeEmployeeFirstName(String firstNameRequest, int employeeID) {
        getEmployeeByID(employeeID).setFirstName(firstNameRequest);
    }

    public void changeEmployeeLastName(String lastNameRequest, int employeeID) {
        getEmployeeByID(employeeID).setLastName(lastNameRequest);
    }

    public void changeEmployeeStreetAddress(String addressStreetRequest, int employeeID) {
        getEmployeeByID(employeeID).setStreetAddress(addressStreetRequest);
    }

    public void changeEmployeeZipcode(String ZipcodeRequest, int employeeID) {
        getEmployeeByID(employeeID).setZipcode(ZipcodeRequest);
    }

    public void changeEmployeePhoneNumber(String phoneNumberRequest, int employeeID) {
        getEmployeeByID(employeeID).setPhoneNumber(phoneNumberRequest);
    }

    public void changeEmployeeEmailAddress(String emailAddressRequest, int employeeID) {
        getEmployeeByID(employeeID).setEmailAddress(emailAddressRequest);
    }

    public void changeEmployeeStartDate(LocalDate startDateRequest, int employeeID) {
        getEmployeeByID(employeeID).setStartDate(startDateRequest);
    }

    public void changeEmployeeDOB(LocalDate dateOfBirthRequest, int employeeID) {
        getEmployeeByID(employeeID).setDateOfBirth(dateOfBirthRequest);
    }

    public void populateCustomer(List<Customer> allCustomers) {
        for(Customer current : allCustomers){
            customers.put(current.getCustId(), current);
        }
    }
}
