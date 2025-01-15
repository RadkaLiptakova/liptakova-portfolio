package com.ictdemy.data.repositories;

import com.ictdemy.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository interface for managing {@link UserEntity} instances.
 * Provides CRUD operations and additional methods for querying {@link UserEntity} data.
 * Extends the {@link CrudRepository} interface provided by Spring Data JPA.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * Finds a {@link UserEntity} by its email address.
     *
     * @param email the email address of the user.
     * @return an {@link Optional} containing the user if found, or empty if not found.
     */
    Optional<UserEntity> findByEmail(String email);
}
