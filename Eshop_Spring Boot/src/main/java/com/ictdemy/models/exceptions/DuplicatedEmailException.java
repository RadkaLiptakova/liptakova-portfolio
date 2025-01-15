package com.ictdemy.models.exceptions;

/**
 * Exception thrown when a user attempts to register with an email that is already in use.
 * It extends {@link RuntimeException} to allow for
 * unchecked exceptions in the application flow.
 */
public class DuplicatedEmailException extends RuntimeException {
}
