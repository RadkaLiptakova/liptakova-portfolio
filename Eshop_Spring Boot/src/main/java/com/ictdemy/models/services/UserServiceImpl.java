package com.ictdemy.models.services;

import com.ictdemy.data.entities.UserEntity;
import com.ictdemy.data.repositories.UserRepository;
import com.ictdemy.models.dto.UserDTO;
import com.ictdemy.models.exceptions.DuplicatedEmailException;
import com.ictdemy.models.exceptions.PasswordDoNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link UserService} interface for managing user-related operations.
 * This service handles the creation of new users and user authentication. It interacts with the
 * {@link UserRepository} to manage user data and with Spring Security to authenticate users.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Creates a new user with the provided details.
     * The method checks if the password and confirm password match. If they do, the user's
     * email is saved in the database with an encrypted password. The {@link DuplicatedEmailException}
     * is thrown if the email is already in use.
     *
     * @param user the {@link UserDTO} containing user data (email, password, and confirmation).
     * @param isAdmin a flag to determine if the user is an administrator.
     * @throws PasswordDoNotMatchException if the password and confirm password do not match.
     * @throws DuplicatedEmailException if the email is already registered.
     */
    @Override
    public void create(UserDTO user, boolean isAdmin) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new PasswordDoNotMatchException();
        }
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setAdmin(isAdmin);

        try {
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicatedEmailException();
        }
    }

    /**
     * Loads a user by their username (email).
     * This method is used by Spring Security for authentication. If the user is not found, a
     * {@link UsernameNotFoundException} is thrown.
     *
     * @param username the email of the user to be authenticated.
     * @return a {@link UserDetails} object representing the authenticated user.
     * @throws UsernameNotFoundException if the user with the given username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + ", not found"));
    }
}
