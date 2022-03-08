package com.epam.selenium.properties.holder.exception;

public class BrowserPropertiesNotFoundException extends RuntimeException {
    public BrowserPropertiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
