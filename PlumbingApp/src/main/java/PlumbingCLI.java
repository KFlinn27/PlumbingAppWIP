import Task.PlumbingMenu;
import dao.JdbcCustomerDao;
import dao.JdbcEmployeeDao;
import org.apache.commons.dbcp2.BasicDataSource;
import person.Employee;


import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
        customerDao = new JdbcCustomerDao(dataSource);
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
            } else if(choice == 4){
                break;
            }
            //exit program
            else {
                System.out.println("You should not see this, how did the user get to the else?");
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
            } else if(choice == 4){
                break;
            } else{
                System.out.println("You shouldn't be seeing this. Contain the search");
                choice = menu.plumbingResourceOptions();
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

    private void manageCompany(Company company) {
        while (true) {
            //Company management
            int choice = menu.companyManagementOptions();
            if (choice == 1) {
                //Adding Employee
                company.addEmployee(created());

            } else if (choice == 2) {

                //select an existing employee
                int employeeID = getEmployIdToEdit(company.getEmployees());

                //user has provided a valid employee ID to edit and confirmed, loading editing menu
                editEmployee(company, employeeID);

            } else if (choice == 3) {
                //Lists various things about employees
                choice = menu.listEmployeesOptions();
                employeeOptions(choice, company.getEmployees());
                //list all employees
            } else if (choice == 4) {
                //add a task
                menu.hereMessage();
            } else if (choice == 5) {
                //edit a task
                menu.hereMessage();
            } else if(choice == 6){
                break;
            } else {
                System.out.println("You shouldn't be seeing this. Contain the search");
            }
        }
    }

    private void employeeOptions(int choice, TreeMap<Integer, Employee> employees) {

        if (choice == 1) {
            menu.listAllEmployees(employees);

        } else if (choice == 2) {
            /*
I believe this method should interact with the database to track concurrent entries from others rather than the built
in data.

for(Map.Entry<Integer, Employee> current: employees.entrySet()){
                if(LocalDate.now().getMonth() == current.getValue().getStartDate().getMonth()){
                    //display their info plus how many years from hire date
                    int years = LocalDate.now().getYear() - current.getValue().getStartDate().getYear();
                    menu.displayEmployeeAnniversary(current.getValue(), years);
                }
            }*/
            List<Employee> employeeAnni = employeeDao.getEmployeeAnniversaries();
            for (Employee current : employeeAnni) {
                int years = LocalDate.now().getYear() - current.getStartDate().getYear();
                menu.displayEmployeeAnniversary(current, years);
            }
            menu.breakLines();
        } else {
            menu.returningMessage();
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
