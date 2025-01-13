package com.ictdemy;

import java.util.Scanner;

/**
 * Handles inputs, outputs and interaction with the user.
 */
public class UserInterface {

    private Scanner scanner; //Scanner for user input

    /**
     * Constructor to initialize the required components for handling inputs, outputs and user interaction.
     */
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints the main menu to the console.
     */
    public void printMainMenu() {
        System.out.println("-------------------------");
        System.out.println("Insurance App");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("Controlling options for the Insurance app:");
        System.out.println("1 - Add a new insured person");
        System.out.println("2 - List all of the insured persons");
        System.out.println("3 - Search for an insured person");
        System.out.println("4 - Delete an insured person");
        System.out.println("5 - End the application");
    }

    /**
     * Gets a non-empty input from the user.
     *
     * @param prompt The prompt message to display in the console.
     * @return A valid non-empty string
     */
    public String getNonEmptyInput(String prompt) {
        String input = "";
        while ((input.isEmpty())) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
        return input;
    }

    /**
     * Gets a valid phone number according to the example.
     *
     * @param prompt The prompt message to display in the console.
     * @return A valid phone number in the correct form.
     */
    public String getValidTelNumber(String prompt) {
        String input = "";
        while ((!input.startsWith("+421") || input.length() != 13)) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if ((!input.startsWith("+421") || input.length() != 13)) {
                System.out.println("Wrong phone number type. Please, enter the phone number according to the example.");
            }
        }
        return input;
    }

    /**
     * Gets a valid integer input from the user.
     *
     * @param prompt The prompt message to display in the console.
     * @return A valid integer.
     */
    public int getValidIntInput(String prompt) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }

    /**
     * Gets a valid integer input within the given range.
     *
     * @param prompt The prompt message to display in the console.
     * @param min    The minimal integer from the range.
     * @param max    The maximal integer from the range.
     * @return A valid integer within the given range.
     */
    public int getValidIntWithinRange(String prompt, int min, int max) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            input = getValidIntInput(prompt);
            if (input < min || input > max) {
                System.out.println("Invalid input. Please enter a number from " + min + " to " + max + ".");
            } else {
                isValid = true;
            }
        }
        return input;
    }

    /**
     * Waits for the user to press any key to continue the Insurance app.
     */
    public void waitForUserToContinue() {
        System.out.println("If you wish to continue, press any keyboard...");
        scanner.nextLine();
    }

    /**
     * Closes the scanner.
     */
    public void closeScanner() {
        scanner.close();
    }
}