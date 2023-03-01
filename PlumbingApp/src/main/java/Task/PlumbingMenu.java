package Task;

import person.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PlumbingMenu {
    private final String DASH_LINE_BREAK = "--------------------------------------------------";

    Scanner userInput = new Scanner(System.in);

    public String firstNameRequest() {
        System.out.print("What is the first name of the person you're adding?");
        String first = userInput.nextLine();
        System.out.println();
        return first;
    }

    public String lastNameRequest() {
        System.out.print("What is the last name of the person you're adding?");
        String last = userInput.nextLine();
        System.out.println();
        return last;
    }

    public String addressStreetRequest() {
        System.out.print("What is the street address of the person you're adding?");
        String st = userInput.nextLine();
        System.out.println();
        return st;
    }

    public String zipcodeRequest() {
        System.out.print("What is the zipcode of the person you're adding?");
        String zip = userInput.nextLine();
        System.out.println();
        return zip;
    }

    public String emailAddressRequest() {
        System.out.print("What is the email address of the person you're adding?");
        String email = userInput.nextLine();
        System.out.println();
        return email;
    }

    public String phoneNumberRequest() {
        System.out.print("What is the phone number of the person you're adding?");
        String phone = userInput.nextLine();
        System.out.println();
        return phone;
    }

    public void displayMessage() {
        breakLines();
        System.out.println("Welcome to K&F Plumbing Management!");
        breakLines();
    }

    public int displayInitialOptions() {
        System.out.println();
        System.out.println("[1] Please enter 1 for Company Management!");
        System.out.println("[2] Please enter 2 for Customer Management!");
        System.out.println("[3] Please enter 3 to access Plumbing Resources!");
        System.out.println("[4] Please enter 4 to exit!");
        System.out.print("Please enter your choice: ");
        return userChoice(1, 4);
    }

    public int companyManagementOptions() {
        System.out.println();
        System.out.println("[1] Please enter 1 to add a new employee!");
        System.out.println("[2] Please enter 2 to edit an employee!");
        System.out.println("[3] Please enter 3 to view employees in various ways!");
        System.out.println("[4] Please enter 4 to add a preset task!");
        System.out.println("[5] Please enter 5 to edit a preset task!");
        System.out.println("[6] Please enter 6 to be finished with company management.");
        System.out.print("Please enter your choice: ");
        return userChoice(1, 6);
    }

    public int editEmployeeMessage() {
        System.out.println();
        System.out.println("[1] Please enter 1 to edit their first name!");
        System.out.println("[2] Please enter 2 to edit their last name!");
        System.out.println("[3] Please enter 3 to edit their street address!");
        System.out.println("[4] Please enter 4 to edit their zipcode!");
        System.out.println("[5] Please enter 5 to edit their phone number!");
        System.out.println("[6] Please enter 6 to edit their email address!");
        System.out.println("[7] Please enter 7 to edit their start date!");
        System.out.println("[8] Please enter 8 to edit their DOB!");
        System.out.println("[9] Please enter 9 to delete an employee!");
        System.out.println("[10] Please enter 10 to finish editing.");
        System.out.print("Please enter your choice: ");
        return userChoice(1, 10);
    }

    public int customerManagementOptions() {
        System.out.println();
        System.out.println("[1] Please enter 1 to add a new customer!");
        System.out.println("[2] Please enter 2 to edit a customer!");
        System.out.println("[3] Please enter 3 to blacklist a customer!");
        System.out.println("[4] Please enter 4 to add a WO to a customer!");
        System.out.println("[5] Please enter 5 to remove a WO from a customer!");
        System.out.println("[6] Please enter 6 to be finished with company management.");
        System.out.print("Please enter your choice: ");
        return userChoice(1, 6);
    }

    public int plumbingResourceOptions() {
        System.out.println("[1] Please enter 1 to use the off-set calculator!");
        System.out.println("[2] Please enter 2 to open Charlotte's dimensional catalog!");
        System.out.println("[3] Please enter 3 to view Ohio's latest code publication!");
        System.out.println("[4] Please enter 4 to go back to previous menu!");
        System.out.print("Please enter your choice: ");
        return userChoice(1, 4);
    }

    public void choiceError() {
        System.err.print("You did not select an available choice or did not enter a number. Try again:");
    }

    public void displayEmployees(Map<Integer, Employee> employees) {
        for (Map.Entry<Integer, Employee> current : employees.entrySet()) {
            System.out.println(current.getValue().toString());
        }
    }

    public void hereMessage() {
        System.out.println("You're here");
    }

    public int userChoice(int lower, int upper) {
        int choice = 0;
        try {
            choice = Integer.parseInt(userInput.nextLine());
            while (choice < lower || choice > upper) {
                choiceError();
                choice = Integer.parseInt(userInput.nextLine());
                System.err.println();
            }

        } catch (NumberFormatException e) {
            choiceError();
        }
        System.out.println();
        breakLines();
        return choice;
    }

    public LocalDate startDateRequest() {
        System.out.print("Is this employee starting today?(Y/N)");
        String answer = userInput.nextLine();
        System.out.println();
        LocalDate startDate = null;
        if (answer.equalsIgnoreCase("y")) {
            return LocalDate.now();
        } else {
            while (true) {
                System.out.print("What day will the employee start?(YYYY-MM-DD)");
                answer = userInput.nextLine();
                System.out.println();
                try {
                    startDate = LocalDate.parse(answer);
                } catch (DateTimeParseException e) {
                    System.out.println();
                    System.err.println("You did not enter a valid string. Please enter a date as YYYY-MM-DD.");
                }
                if (startDate != null) {
                    break;
                }
            }

        }
        return startDate;
    }


    public LocalDate dateOfBirthRequest() {
        LocalDate dob = null;
        while (true) {
            System.out.print("What is the employee's DOB?(YYYY-MM-DD)");
            String answer = userInput.nextLine();
            System.out.println();
            try {
                dob = LocalDate.parse(answer);
            } catch (DateTimeParseException e) {
                System.out.println();
                System.err.println("You did not enter a valid string. Please enter a date as YYYY-MM-DD.");
                ;
            }
            if (dob != null) {
                break;
            }
        }
        return dob;
    }

    public void listAllEmployees(TreeMap<Integer, Employee> employees) {
        System.out.println(wrap("Here are all current employees"));
        if (employees == null || employees.size() == 0){
            System.out.println("Employees have not been initiated. Or there" +
                    "are no employees in the company.");}
        else {
            for (Map.Entry<Integer, Employee> current : employees.entrySet()) {
                System.out.println(current.getValue().toString());
            }
            breakLines();
        }
    }

    public int selectEmployee(int option) {
        if (option == 0) {
            System.out.print("What is the ID of the employee you would like to edit?(Enter -1 to exit)");
        } else {
            System.out.print("That ID is not valid. Please enter another ID or -1 to exit.");
        }
        option = Integer.parseInt(userInput.nextLine());
        System.out.println();
        return option;
    }

    public int confirmEmployee(Employee employee) {
        System.out.println(employee.toString());
        System.out.println("Is this the employee you would like to edit?(Y/N)");
        String correct = userInput.nextLine();
        System.out.println();
        if (correct.equalsIgnoreCase("y")) {
            return employee.getEmployID();
        } else {
            return 0;
        }

    }

    public void employeeDeletionMessage(Employee employee) {

        System.out.println(employee.fullName() + " was removed from the company.");
        breakLines();
    }

    public int listEmployeesOptions() {
        System.out.println();
        System.out.println("[1] Please enter 1 to view all employees!");
        System.out.println("[2] Please enter 2 to view employees with their anniversary this month!");
        System.out.println("[3] Please enter 3 to be return to previous menu.");
        return userChoice(1, 3);
    }

    public void displayEmployeeAnniversary(Employee value, int years) {
        System.out.println(value.getFirstName() + " " + value.getLastName() + " is celebrating their " + years + "-year " +
                "anniversary with the company!");
    }

    public void returningMessage() {
        System.out.println("Returning to previous menu.");
        breakLines();
    }

    public void breakLines() {
        System.out.println(DASH_LINE_BREAK);
    }

    public String wrap(String msgToWrap){

        /*
        If msg being wrapped is odd, we need to add an additional - char to the end of the return string
        dash line final is 50 chars, msgtowrap is 25, each side gets 12, total 49, 1 left over throw on end
        msg to wrap is 26, each side gets 12, returned string is 50
        */

//        int wrapLength = (DASH_LINE_BREAK.length() - msgToWrap.length())/2;
//        String wrapper = DASH_LINE_BREAK.substring(0, wrapLength);
//        boolean wrapOdd = (msgToWrap.length() % 2) == 1;
//        String wrapped = wrapper.concat(msgToWrap).concat(wrapper);
//        return wrapOdd ? wrapped.concat("-") : wrapped;


        StringBuilder wrapped = new StringBuilder(DASH_LINE_BREAK);
        wrapped.insert((DASH_LINE_BREAK.length()-msgToWrap.length())/2, msgToWrap);
        return wrapped.toString().substring(0, DASH_LINE_BREAK.length());

    }
}
