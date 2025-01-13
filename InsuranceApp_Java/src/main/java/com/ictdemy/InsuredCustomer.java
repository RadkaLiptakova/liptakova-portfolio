package com.ictdemy;

/**
 * Represents an insured customer with personal details.
 */
public class InsuredCustomer {

    private int customerId; //Unique identification number of the customer in the database
    private String firstName; //First name of the insured customer
    private String lastName; //Last name of the insured customer
    private String telNumber; //Phone number of the insured customer
    private int age; //Age of the insured customer

    /**
     * Constructor to initialize an insured customer.
     *
     * @param customerId Unique identification number of the customer in the database.
     * @param firstName  First name of the insured customer.
     * @param lastName   Last name of the insured customer.
     * @param telNumber  Phone number of the insured customer.
     * @param age        Age of the insured customer.
     */
    public InsuredCustomer(int customerId, String firstName, String lastName, String telNumber, int age) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNumber = telNumber;
        this.age = age;
    }

    //Getters for the names and customer ID
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCustomerId() {
        return customerId;
    }

    /**
     * Displays the insured customer in the console.
     *
     * @return A formatted string representation of the insured customer
     */
    @Override
    public String toString() {
        return String.format("%-5d %-15s %-15s %-15s %-5d", customerId, firstName, lastName, telNumber, age);
    }
}