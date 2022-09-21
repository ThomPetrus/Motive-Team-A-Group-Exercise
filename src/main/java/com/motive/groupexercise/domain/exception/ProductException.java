package com.motive.groupexercise.domain.exception;


/**
 * Standard custom exception class to be caught by the custom handler.
 * Occurs when anything goes wrong getting/setting product from db
 */
public class ProductException extends RuntimeException {

    /**
     * Standard override of RunTimeException to be caught appropriately.
     *
     * @param message - error message
     */
    public ProductException(String message) {
        super(message);
    }


    /**
     * Standard override of RunTimeException to be caught appropriately.
     *
     * @param message - error message
     * @param cause - throwable cause
     */
    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

}
