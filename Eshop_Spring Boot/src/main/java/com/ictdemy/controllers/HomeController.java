package com.ictdemy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling requests to the home and "About Us" pages.
 * Provides endpoints for rendering the index and "About Us" pages of the application.
 */
@Controller
public class HomeController {

    /**
     * Displays the home page of the application.
     *
     * @return the path to the home page template.
     */
    @GetMapping("/")
    public String renderIndex(){
        return "pages/home/index";
    }

    /**
     * Displays the "About Us" page of the application.
     *
     * @return the path to the "About Us" page template.
     */
    @GetMapping("/about-us")
    public String renderAboutEshop(){
        return "pages/home/about-us";
    }
}
