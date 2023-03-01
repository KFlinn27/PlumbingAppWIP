import Task.PlumbingMenu;
import dao.JdbcCustomerDao;
import dao.JdbcEmployeeDao;
import org.apache.commons.dbcp2.BasicDataSource;
import person.Employee;


import javax.sql.DataSource;
import java.util.TreeMap;

public class PlumbingCLI {
    PlumbingMenu menu = new PlumbingMenu();
    JdbcEmployeeDao employeeDao;
    JdbcCustomerDao customerDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/plumbingCompany");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        PlumbingCLI application = new PlumbingCLI(dataSource);
        application.run();
    }


    public PlumbingCLI(DataSource dataSource) {
        employeeDao = new JdbcEmployeeDao(dataSource);
    }


    public void run() {


        Company company = new Company();
        company.populateEmployees(employeeDao.getAllEmployees());
        company.populateCustomer(customerDao.getAllCustomers());


        menu.displayMessage();
        while (true) {
            int choice = menu.displayInitialOptions();


            if (choice == 1) {
                //manage company
                manageCompany(company);
            } else if (choice == 2) {
                //manage customers
                manageCustomer(company);
            } else if (choice == 3) {
                //Plumbing Resources
                resources();
            }
            //exit program
            else {
                break;
            }
        }
        //Close out anything open or write leftover data


    }

    private void resources() {
        while (true) {
            int choice = menu.plumbingResourceOptions();
            if (choice == 1) {
                //offset calculator
            } else if (choice == 2) {
                //access charlotte's dimension catalog
            } else if (choice == 3) {
                //access ohio latest code pub
            } else {
                break;
            }
        }
    }

    private void manageCustomer(Company kAndF) {
        while (true) {
            int choice = menu.customerManagementOptions();
            if (choice == 1) {
                //add new customer
                menu.hereMessage();
            } else if (choice == 2) {
                //edit an existing customer
                menu.hereMessage();
            } else if (choice == 3) {
                //blacklist a customer
                menu.hereMessage();
            } else if (choice == 4) {
                //assign work order to customer
                menu.hereMessage();
            } else if (choice == 5) {
                //close a work order assigned to a customer
                menu.hereMessage();
            } else {
                break;
            }
        }
    }

    private void manageCompany(Company kAndF) {
        while (true) {
            //Company management
            int choice = menu.companyManagementOptions();
            if (choice == 1) {
                //Adding Employee
                kAndF.addEmployee(created());

            } else if (choice == 2) {

                //select an existing employee
                int employeeID = getEmployIdToEdit(kAndF.getEmployees());

                //user has provided a valid employee ID to edit and confirmed, loading editing menu
                editEmployee(kAndF, employeeID);

            } else if (choice == 3) {
                //list all employees
                menu.listAllEmployees(kAndF.getEmployees());
            } else if (choice == 4) {
                //add a task
                menu.hereMessage();
            } else if (choice == 5) {
                //edit a task
                menu.hereMessage();
            } else {
                break;
            }
        }
    }

    private void editEmployee(Company kAndF, int employeeID) {
        while (true) {
            int choice = 0;
            if (employeeID >= 0) {
                choice = menu.editEmployeeMessage();
            }
            if (choice == 1) {
                //Edit first name
                kAndF.changeEmployeeFirstName(menu.firstNameRequest(), employeeID);
            } else if (choice == 2) {
                kAndF.changeEmployeeLastName(menu.lastNameRequest(), employeeID);
            } else if (choice == 3) {
                kAndF.changeEmployeeStreetAddress(menu.addressStreetRequest(), employeeID);
            } else if (choice == 4) {
                kAndF.changeEmployeeZipcode(menu.zipcodeRequest(), employeeID);
            } else if (choice == 5) {
                kAndF.changeEmployeePhoneNumber(menu.phoneNumberRequest(), employeeID);
            } else if (choice == 6) {
                kAndF.changeEmployeeEmailAddress(menu.emailAddressRequest(), employeeID);
            } else if (choice == 7) {
                kAndF.changeEmployeeStartDate(menu.startDateRequest(), employeeID);
            } else if (choice == 8) {
                kAndF.changeEmployeeDOB(menu.dateOfBirthRequest(), employeeID);
            } else if (choice == 9) {
                menu.employeeDeletionMessage(kAndF.getEmployeeByID(employeeID));
                kAndF.removeEmployee(employeeID);
                employeeDao.removeEmployee(employeeID);
                break;
            } else {
                if (employeeID > 0) employeeDao.updateEmployee(kAndF.getEmployeeByID(employeeID));
                break;
            }
        }
    }

    private Employee created() {
        Employee created = createEmployee();
        created = employeeDao.createEmployee(created);
        return created;
    }

    private int getEmployIdToEdit(TreeMap<Integer, Employee> employees) {
        int id = menu.selectEmployee(0);
        while (id > 0) {
            if (employees.containsKey(id)) {
                if (menu.confirmEmployee(employees.get(id)) == id) {
                    break;
                } else {
                    id = menu.selectEmployee(0);
                }
            } else {
                id = menu.selectEmployee(1);
            }
        }
        return id;
    }

    public Employee createEmployee() {
        //TODO vet all of these inputs to ensure employee is valid
        return new Employee(menu.firstNameRequest(), menu.lastNameRequest(), menu.addressStreetRequest(),
                menu.zipcodeRequest(), menu.phoneNumberRequest(), menu.emailAddressRequest(), menu.startDateRequest(), menu.dateOfBirthRequest());

    }


}
