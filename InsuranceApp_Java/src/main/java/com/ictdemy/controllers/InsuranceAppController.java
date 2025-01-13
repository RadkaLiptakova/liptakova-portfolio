package com.ictdemy.controllers;

import com.ictdemy.services.InsuranceAppService;
import com.ictdemy.InsuranceDatabase;
import com.ictdemy.UserInterface;

/**
 * Handles the main flow of the Insurance application.
 */
public class InsuranceAppController {

    private UserInterface userInterface; //Handles interaction with the user
    private InsuranceAppService insuranceAppService; //Handles the logic of the application

    /**
     * Constructor to initialize the required components for managing the main flow of the Insurance application.
     *
     * @param userInterface User interface for input/output operations.
     */
    public InsuranceAppController(UserInterface userInterface) {
        InsuranceDatabase insuranceDatabase = new InsuranceDatabase();
        this.userInterface = userInterface;
        this.insuranceAppService = new InsuranceAppService(userInterface, insuranceDatabase);
    }

    /**
     * Starts the main loop of the Insurance application.
     */
    public void runInsuranceApp() {
        int option = 0;
        while (option != 5) {
            //Displays the main menu
            userInterface.printMainMenu();
            option = userInterface.getValidIntInput("Choose one of the options above:");
            System.out.println();

            //Handles menu options
            switch (option) {
                case 1:
                    insuranceAppService.addNewInsuredCustomer(); //Adds a new insured customer
                    break;
                case 2:
                    insuranceAppService.showAllInsuredCustomers(); //Displays all the insured customers
                    break;
                case 3:
                    insuranceAppService.searchInsuredCustomer(); //Searches for an insured customer/customers
                    break;
                case 4:
                    insuranceAppService.deleteInsuredCustomer(); //Deletes an insured customer according to the customer ID
                    break;
                case 5:
                    System.out.println("Application ended."); //Ends the app
                    break;
                default:
                    System.out.println("Wrong option. Please, try and enter one of the correct options.");
                    break;

            }
        }
        userInterface.closeScanner();
    }
}