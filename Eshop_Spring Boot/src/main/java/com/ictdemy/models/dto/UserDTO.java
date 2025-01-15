package com.ictdemy.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) representing a user.
 * This class is used to transfer user data, including email and password, between
 * layers such as the controller and service. It includes validation annotations for
 * email format and password strength.
 */
public class UserDTO {

    /**
     * The user's email address.
     * This field is validated to ensure it contains a valid email format and is not blank.
     */
    @Email(message = "Enter valid email")
    @NotBlank(message = "Enter user email")
    private String email;

    /**
     * The user's password.
     * This field is validated to ensure it is not blank and has a minimum length of 6 characters.
     */
    @NotBlank(message = "Enter user password")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;

    /**
     * The user's password confirmation.
     * This field is validated similarly to the password field to ensure it meets
     * the minimum length requirement and is not blank.
     */
    @NotBlank(message = "Enter user password")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String confirmPassword;

    /**
     * Gets the user's email.
     *
     * @return the email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password confirmation.
     *
     * @return the confirmed password.
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets the user's password confirmation.
     *
     * @param confirmPassword the confirmed password to set.
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Gets the user's password.
     *
     * @return the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
