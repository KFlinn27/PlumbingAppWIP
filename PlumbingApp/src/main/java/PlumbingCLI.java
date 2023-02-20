import Task.PlumbingMenu;

import java.util.Scanner;

public class PlumbingCLI {

    public void run(){
        PlumbingMenu menu = new PlumbingMenu();

        //write new customers to txt file?
        //write all data to txt files?
        //wait to learn about database integration




        menu.displayMessage();
        while(true){
            int choice = menu.displayInitialOptions();
            //manage company
            if(choice == 1){
                while(true){
                    //Company management
                    choice = menu.companyManagementOptions();
                    if(choice == 1){
                        //add new employee
                        menu.hereMessage();
                    }
                    else if(choice == 2){
                        //edit an existing employee
                        menu.hereMessage();
                    }
                    else if(choice == 3){
                        //add a task
                        menu.hereMessage();
                    }
                    else if(choice == 4){
                        //edit a task
                        menu.hereMessage();
                    }
                    else{
                        break;
                    }
                }
            }
            //manage customer

            else if(choice == 2){
                while(true) {
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
            }

            else if(choice == 3){
                //Plumbing Resources
                while(true) {
                    choice = menu.plumbingResourceOptions();
                    if(choice == 1){
                        //offset calculator
                    }
                    else if(choice == 2){
                        //access charlotte's dimension catalog
                    }
                    else if(choice == 3){
                        //access ohio latest code pub
                    }
                    else{
                        break;
                    }
                }
            }
            //exit program
            else{
                break;
            }
        }
        //Close out anything open or write leftover data




    }




}
