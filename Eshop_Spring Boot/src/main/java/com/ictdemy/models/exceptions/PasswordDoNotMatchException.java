package com.ictdemy.models.exceptions;

/**
 * Exception thrown when the password and confirm password do not match during user registration.
 * It extends {@link RuntimeException} to allow for unchecked exceptions.
 */
public class PasswordDoNotMatchException extends RuntimeException{
}
