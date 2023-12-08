package ru.cft.focus.exceptions;

public class ConsoleReaderException extends RuntimeException {

    private static final String ERROR_MSG = "Error while reading input parameter: ";
    private final String message;

    public ConsoleReaderException(String message) {
        this.message = ERROR_MSG + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
