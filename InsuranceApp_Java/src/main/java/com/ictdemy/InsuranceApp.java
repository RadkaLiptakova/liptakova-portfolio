package com.ictdemy;

import com.ictdemy.controllers.InsuranceAppController;

/**
 * Main class of the Insurance Application
 */
public class InsuranceApp {
    public static void main(String[] args) {
        //Creating the app controller for starting the application
        InsuranceAppController app = new InsuranceAppController(new UserInterface());
        app.runInsuranceApp(); //Starts the application
    }
}