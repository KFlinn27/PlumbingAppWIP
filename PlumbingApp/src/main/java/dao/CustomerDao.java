package dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import person.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();
    public Customer createCustomer(Customer customer);

    public void deleteAllCustomers();

    public Customer mapCustomerFromRowSet(SqlRowSet current);
}
