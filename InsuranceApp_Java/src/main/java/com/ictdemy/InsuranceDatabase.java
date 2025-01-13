package com.ictdemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handles the storage and retrieval of the insured customers in the Insurance app.
 */
public class InsuranceDatabase {

    private List<InsuredCustomer> insuredCustomers; //List of the insured customers in the Insurance app
    private static int customerIdCounter = 1; //Static counter for assigning the unique customer IDs

    /**
     * Constructor to initialize the required components of the database.
     */
    public InsuranceDatabase() {
        this.insuredCustomers = new ArrayList<>();

    }

    /**
     * Adds a new insured customer into the database.
     *
     * @param firstName First name of the customer.
     * @param lastName  Last name of the customer.
     * @param telNumber Phone number of the customer.
     * @param age       Age of the customer.
     */
    public void addInsuredCustomer(String firstName, String lastName, String telNumber, int age) {
        int customerId = customerIdCounter++;
        insuredCustomers.add(new InsuredCustomer(customerId, firstName, lastName, telNumber, age));
    }

    /**
     * Retrieves all the insured customers.
     *
     * @return An unmodifiable list of all the insured customers in the database.
     */
    public List<InsuredCustomer> getAllInsuredCustomers() {
        return Collections.unmodifiableList(insuredCustomers);
    }

    /**
     * Finds the insured customer in the database by first and last name.
     *
     * @param firstName First name to search for in the database.
     * @param lastName  Last name to search for in the database.
     * @return Matching insured customer/s, or null if the customer is not in the database.
     */
    public List<InsuredCustomer> findInsuredCustomers(String firstName, String lastName) {
        List<InsuredCustomer> matchingCustomers = new ArrayList<>();

        for (InsuredCustomer customer : insuredCustomers) {
            if (customer.getFirstName().equalsIgnoreCase(firstName) && customer.getLastName().equalsIgnoreCase(lastName)) {
                matchingCustomers.add(customer);
            }
        }
        return matchingCustomers;
    }

    /**
     * Deletes the insured customer from the database according to the customer's ID.
     *
     * @param id Unique identification number of the customer in the database
     * @return Indication of a successful deletion.
     */
    public boolean deleteInsuredCustomer(int id) {
        for (InsuredCustomer customer : insuredCustomers) {
            if (customer.getCustomerId() == id) {
                insuredCustomers.remove(customer);
                return true;
            }
        }
        return false;
    }
}