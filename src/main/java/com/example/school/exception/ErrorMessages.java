package com.example.school.exception;

public final class ErrorMessages {

    protected static final String RESOURCE_NOT_FOUND_ERROR = "The requested resource not found";
    protected static final String ALREADY_EXISTS_ERROR = "The requested resource already exists";

    protected static final String DATA_ACCESS_ERROR = "An error occurred while accessing data";
    protected static final String DUPLICATE_ENTRY_ERROR = "Duplicate entry detected";

    protected static final String AUTHENTICATION_FAILED = "Authentication failed";
    protected static final String INVALID_CREDENTIALS = "Invalid username or password";

    protected static final String VALIDATION_ERROR = "Validation failed";

    protected static final String TOO_MANY_REQUESTS = "Too many requests, please try again later";

    protected static final String INTERNAL_SERVER_ERROR = "Unexpected error occurred while processing your request.";

    protected static final String STATUS_ALREADY_SET = "The user's status is already set to the requested value.";

    private ErrorMessages() {
    }

}