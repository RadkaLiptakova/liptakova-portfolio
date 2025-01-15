package com.ictdemy.models.services;

import com.ictdemy.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Service interface for managing users in the application.
 * This interface extends {@link UserDetailsService} to integrate with Spring Security's
 * user authentication and provides additional functionality for creating users.
 */
public interface UserService extends UserDetailsService {

    /**
     * Creates a new user.
     *
     * @param user the {@link UserDTO} containing the user data to be created.
     * @param isAdmin flag indicating whether the user should be an administrator.
     */
    void create(UserDTO user, boolean isAdmin);
}
