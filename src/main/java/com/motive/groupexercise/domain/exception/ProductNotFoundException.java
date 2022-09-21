package com.motive.groupexercise.domain.exception;

/**
 * Standard custom exception class to be caught by the custom handler.
 * Occurs when a product is not found
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Simple exception to be thrown if no product is not found in repo
     *
     * @param message - Product not found message to be passed to this exception.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}
