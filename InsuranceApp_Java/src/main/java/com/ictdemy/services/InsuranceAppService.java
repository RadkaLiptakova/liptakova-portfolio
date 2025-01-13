package com.ictdemy.services;

import com.ictdemy.InsuranceDatabase;
import com.ictdemy.InsuredCustomer;
import com.ictdemy.UserInterface;

import java.util.List;

/**
 * Handles the business logic of the Insurance application
 */
public class InsuranceAppService {

    private UserInterface userInterface; //Handles interaction with the user
    private InsuranceDatabase insuranceDatabase;//The database for storing and retrieving insured customers

    /**
     * Constructor to initialize the required components for managing the business logic od the Insurance app.
     *
     * @param userInterface     User interface for input/output operations.
     * @param insuranceDatabase Database for storing and retrieving customer information.
     */
    public InsuranceAppService(UserInterface userInterface, InsuranceDatabase insuranceDatabase) {
        this.userInterface = userInterface;
        this.insuranceDatabase = insuranceDatabase;
    }

    /**
     * Handles adding a new customer into the database with the help of the methods from the UserInterface class.
     */
    public void addNewInsuredCustomer() {
        String firstName = userInterface.getNonEmptyInput("Enter the first name:");
        String lastName = userInterface.getNonEmptyInput("Enter the last name:");
        String telNumber = userInterface.getValidTelNumber("Enter the phone number as +421XXXXXXXXX:");
        int age = userInterface.getValidIntWithinRange("Enter the age:", 1, 130);

        insuranceDatabase.addInsuredCustomer(firstName, lastName, telNumber, age);

        System.out.println();
        System.out.print("The insured customer has been added. ");
        userInterface.waitForUserToContinue();
    }

    /**
     * Displays all the insured customers in the Insurance app.
     */
    public void showAllInsuredCustomers() {
        List<InsuredCustomer> insuredCustomers = insuranceDatabase.getAllInsuredCustomers();
        if (insuredCustomers.isEmpty()) {
            System.out.println("No insured customers in the database.");
        } else {
            for (InsuredCustomer insuredCustomer : insuredCustomers) {
                System.out.println(insuredCustomer);
            }
        }
        userInterface.waitForUserToContinue();
    }

    /**
     * Handles searching for insured customer/s in the database with the help of the methods from the UserInterface class.
     */
    public void searchInsuredCustomer() {
        String firstName = userInterface.getNonEmptyInput("Enter the first name:");
        String lastName = userInterface.getNonEmptyInput("Enter the last name:");
        System.out.println();

        List<InsuredCustomer> matchingCustomers = insuranceDatabase.findInsuredCustomers(firstName, lastName);

        if (matchingCustomers.isEmpty()) {
            System.out.println("No insured customer under this name.");
        } else {
            for (InsuredCustomer customer : matchingCustomers) {
                System.out.println(customer);
            }
        }
        userInterface.waitForUserToContinue();
    }

    /**
     * Handles deleting the customer with the given ID from the database with the help of the method from the UserInterface class.
     */
    public void deleteInsuredCustomer() {
        int id = userInterface.getValidIntInput("Enter the ID of the customer to be deleted:");
        boolean isDeleted = insuranceDatabase.deleteInsuredCustomer(id);
        if (isDeleted) {
            System.out.print("The insured customer with ID " + id + " has been deleted. ");
        } else {
            System.out.print("No insured customer with the given ID. ");
        }
        userInterface.waitForUserToContinue();
    }
}