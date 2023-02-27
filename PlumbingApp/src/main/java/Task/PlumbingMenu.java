package Task;

import person.Employee;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class PlumbingMenu {

    Scanner userInput = new Scanner(System.in);

    public String firstNameRequest(){
        System.out.println("What is the first name of the person you're adding?");
        return userInput.nextLine();
    }

    public String lastNameRequest(){
        System.out.println("What is the last name of the person you're adding?");
        return userInput.nextLine();
    }

    public String addressStreetRequest(){
        System.out.println("What is the street address of the person you're adding?");
        return userInput.nextLine();
    }

    public String addressZipcodeRequest(){
        System.out.println("What is the zipcode of the person you're adding?");
        return userInput.nextLine();
    }

    public String emailAddressRequest(){
        System.out.println("What is the email address of the person you're adding?");
        return userInput.nextLine();
    }

    public String phoneNumberRequest(){
        System.out.println("What is the phone number of the person you're adding?");
        return userInput.nextLine();
    }

    public void displayMessage(){
        System.out.println("-----------------------------------");
        System.out.println("Welcome to K&F Plumbing Management!");
        System.out.println("-----------------------------------");
    }

    public int displayInitialOptions(){
        System.out.println();
        System.out.println("[1] Please enter 1 for Company Management!");
        System.out.println("[2] Please enter 2 for Customer Management!");
        System.out.println("[3] Please enter 3 to access Plumbing Resources!");
        System.out.println("[4] Please enter 4 to exit!");
        return userChoice(1, 4);
    }

    public int companyManagementOptions(){
        System.out.println();
        System.out.println("[1] Please enter 1 to add a new employee!");
        System.out.println("[2] Please enter 2 to edit an employee!");
        System.out.println("[3] Please enter 3 to add a preset task!");
        System.out.println("[4] Please enter 4 to edit a preset task!");
        System.out.println("[5] Please enter 5 to be finished with company management.");
        return userChoice(1, 5);
    }

    public int editEmployeeMessage(){
        System.out.println();
        System.out.println("[1] Please enter 1 to edit their first name!");
        System.out.println("[2] Please enter 2 to edit their last name!");
        System.out.println("[3] Please enter 3 to edit their street address!");
        System.out.println("[4] Please enter 4 to edit their zipcode!");
        System.out.println("[5] Please enter 5 to edit their phone number!");
        System.out.println("[6] Please enter 6 to edit their email address!");
        System.out.println("[7] Please enter 7 to edit their start date!");
        System.out.println("[8] Please enter 8 to finish editing.");
        return userChoice(1, 8);
    }

    public int customerManagementOptions(){
        System.out.println();
        System.out.println("[1] Please enter 1 to add a new customer!");
        System.out.println("[2] Please enter 2 to edit a customer!");
        System.out.println("[3] Please enter 3 to blacklist a customer!");
        System.out.println("[4] Please enter 4 to add a WO to a customer!");
        System.out.println("[5] Please enter 5 to remove a WO from a customer!");
        System.out.println("[6] Please enter 6 to be finished with company management.");
        return userChoice(1, 6);
    }

    public int plumbingResourceOptions(){
        System.out.println("[1] Please enter 1 to use the off-set calculator!");
        System.out.println("[2] Please enter 2 to open Charlotte's dimensional catalog!");
        System.out.println("[3] Please enter 3 to view Ohio's latest code publication!");
        System.out.println("[4] Please enter 4 to go back to previous menu!");
        return userChoice(1, 4);
    }

    public void choiceError(){
        System.out.println();
        System.err.println("You did not select an available choice or did not enter a number. Try again.");
    }

    public void displayEmployees(Map<Integer, Employee> employees){
        for(Map.Entry<Integer, Employee> current : employees.entrySet()){
            System.out.println(current.getValue().toString());
        }
    }

    public void hereMessage(){
        System.out.println("You're here");
    }

    public int userChoice(int lower, int upper){
        int choice = 0;
        try{
            choice = Integer.parseInt(userInput.nextLine());
            while(choice < lower || choice > upper){
                choiceError();
                choice = Integer.parseInt(userInput.nextLine());
            }

        } catch (NumberFormatException e){
            choiceError();
        }
        System.out.println("-----------------------------------");
        return choice;
    }

    public LocalDate startDateRequest() {
        System.out.println("Is this employee starting today?(Y/N)");
        String answer = userInput.nextLine();
        LocalDate startDate;
        if (answer.equalsIgnoreCase("y")) {
            return LocalDate.now();
        } else {
            System.out.println("What day will the employee start?(YYYY-MM-DD)");
            //TODO vet this response to ensure accurate entry
            answer = userInput.nextLine();
            startDate = LocalDate.parse(answer);
        }
        return startDate;
    }

    public int selectEmployee() {
        System.out.println("What is the ID of the employee you would like to edit?");
        return Integer.parseInt(userInput.nextLine());
    }

    public LocalDate dateOfBirthRequest() {
        System.out.println("What is the employee's DOB?(YYYY-MM-DD)");
        LocalDate dob = LocalDate.parse(userInput.nextLine());
        return dob;
    }
}
