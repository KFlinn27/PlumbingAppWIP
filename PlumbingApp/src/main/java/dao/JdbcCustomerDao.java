package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import person.Customer;

import javax.imageio.plugins.jpeg.JPEGQTable;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT cust_id, first_name, last_name, st_address, zip_code, phone_number, email, " +
                "pet, email_alerts FROM customer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            customers.add(mapCustomerFromRowSet(results));
        }
        return customers;
    }

    @Override
    public Customer mapCustomerFromRowSet(SqlRowSet results) {
        Customer customer = new Customer(results.getString("first_name"), results.getString("last_name"),
                results.getString("st_address"), results.getString("zip_code"), results.getString("phone_number"),
                results.getString("email"), results.getInt("cust_id"), results.getBoolean("pet"),
                results.getBoolean("email_alerts"));
        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (first_name, last_name, st_address, zip_code, phone_number," +
                "email, pet, email_alerts) VALUES(?,?,?,?,?,?,?,?) RETURNING cust_id";
        Integer custId = jdbcTemplate.queryForObject(sql, Integer.class, customer.getFirstName(), customer.getLastName(),
                customer.getStreetAddress(), customer.getZipcode(), customer.getPhoneNumber(), customer.getEmailAddress(),
                customer.isPets(), customer.isEmailAlerts());
        customer.setCustId(custId);
        return customer;
    }

    @Override
    public void deleteAllCustomers() {
        String sql = "DELETE FROM customer";
        jdbcTemplate.update(sql);

    }

}
