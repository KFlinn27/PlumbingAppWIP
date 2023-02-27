import Task.PlumbingMenu;
import dao.JdbcEmployeeDao;
import org.apache.commons.dbcp2.BasicDataSource;
import person.Employee;


import javax.sql.DataSource;
import java.util.Scanner;
public class PlumbingCLI {
    PlumbingMenu menu = new PlumbingMenu();
    JdbcEmployeeDao employeeDao;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/plumbingCompany");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        PlumbingCLI application = new PlumbingCLI(dataSource);
        application.run();
    }



    public PlumbingCLI(DataSource dataSource){
        employeeDao = new JdbcEmployeeDao(dataSource);
    }





    public void run() {


        Company kAndF = new Company();


        menu.displayMessage();
        while (true) {
            int choice = menu.displayInitialOptions();
            //manage company
            if (choice == 1) {
                while (true) {
                    //Company management
                    choice = menu.companyManagementOptions();
                    if (choice == 1) {
                        //create employee
                        Employee created = createEmployee();
                        created = employeeDao.createEmployee(created);
                        // TODO who knows what was happening here
                        System.out.println((created.getEmployID()));
                    } else if (choice == 2) {
                        //select an existing employee, query if ID select exists
                        int employeeID = menu.selectEmployee();

                        //edit an existing employee
                        choice = menu.editEmployeeMessage();
                        if (choice == 1) {
                            kAndF.getEmployee(employeeID).setFirstName(menu.firstNameRequest());

                        } else if (choice == 2) {

                        } else if (choice == 3) {

                        } else if (choice == 4) {

                        } else if (choice == 5) {

                        } else if (choice == 6) {

                        } else if (choice == 7) {

                        } else {
                            break;
                        }
                    } else if (choice == 3) {
                        //add a task
                        menu.hereMessage();
                    } else if (choice == 4) {
                        //edit a task
                        menu.hereMessage();
                    } else {
                        break;
                    }
                }
            }
            //manage customer

            else if (choice == 2) {
                while (true) {
                    choice = menu.customerManagementOptions();
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
            } else if (choice == 3) {
                //Plumbing Resources
                while (true) {
                    choice = menu.plumbingResourceOptions();
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
            //exit program
            else {
                break;
            }
        }
        //Close out anything open or write leftover data


    }

    public Employee createEmployee() {
        return new Employee(menu.firstNameRequest(), menu.lastNameRequest(), menu.addressStreetRequest(),
                menu.addressZipcodeRequest(), menu.phoneNumberRequest(), menu.emailAddressRequest(), menu.startDateRequest(), menu.dateOfBirthRequest());

    }


}
