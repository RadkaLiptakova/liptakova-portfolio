package com.ictdemy.controllers;

import com.ictdemy.models.dto.UserDTO;
import com.ictdemy.models.exceptions.DuplicatedEmailException;
import com.ictdemy.models.exceptions.PasswordDoNotMatchException;
import com.ictdemy.models.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for managing user account-related operations.
 * Handles login and registration requests, including form rendering and user creation.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    /**
     * Displays the login page.
     *
     * @return the path to the login page template.
     */
    @GetMapping("/login")
    public String renderLogin() {
        return "/pages/account/login";
    }

    /**
     * Displays the registration page with an empty {@link UserDTO} model.
     *
     * @param userDTO the user data transfer object for binding registration form data.
     * @return the path to the registration page template.
     */
    @GetMapping("/register")
    public String renderRegister(@ModelAttribute UserDTO userDTO) {
        return "/pages/account/register";
    }

    /**
     * Handles user registration requests.
     * Validates user input, checks for duplicate email and password mismatches,
     * and creates a new user if validation succeeds.
     *
     * @param userDTO            the user data transfer object containing registration details.
     * @param bindingResult      the result of validation checks.
     * @param redirectAttributes attributes for redirecting with messages.
     * @return the path to the registration page if validation fails,
     * or a redirect to the login page if registration succeeds.
     */
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDTO userDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return renderRegister(userDTO);
        }

        try {
            userService.create(userDTO, false);
        } catch (DuplicatedEmailException e) {
            bindingResult.rejectValue("email", "error", "Email already in use");
            return "/pages/account/register";
        } catch (PasswordDoNotMatchException e) {
            bindingResult.rejectValue("password", "error", "The passwords do not match");
            bindingResult.rejectValue("confirmPassword", "error", "The passwords do not match");
            return "/pages/account/register";
        }

        redirectAttributes.addFlashAttribute("success", "User registered");
        return "redirect:/account/login";
    }
}
