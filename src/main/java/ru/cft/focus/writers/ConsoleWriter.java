package ru.cft.focus.writers;

public class ConsoleWriter implements Writer {

    private static final String RESULT_MESSAGE = "Result: pi = ";

    @Override
    public void writeResult(double result) {
        System.out.println(RESULT_MESSAGE + result);
    }

}
