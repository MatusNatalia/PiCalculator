package ru.cft.focus.exceptions;

public class PiCalculatorException extends RuntimeException {

    private static final String ERROR_MSG = "Pi Calculator Exception: ";
    private final String message;

    public PiCalculatorException(String message) {
        this.message = ERROR_MSG + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
