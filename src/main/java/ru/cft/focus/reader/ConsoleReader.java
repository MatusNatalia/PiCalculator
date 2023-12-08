package ru.cft.focus.reader;

import ru.cft.focus.exceptions.ConsoleReaderException;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private static final int MIN_VALUE = 1;
    private static final String START_MSG = "Please enter number of terms:";
    private static final String HELP_MSG = "\nPlease enter number of terms from keyboard." +
            " Size must be >" + MIN_VALUE;
    private static final String INVALID_NUF_OF_TERMS_MSG = "invalid number of terms: ";
    private static final String SYMBOL_NOT_INT_MSG = "entered symbol is not an integer";

    @Override
    public int readInputParameter() {
        int numOfTerms;
        System.out.println(START_MSG);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextInt()) {
                    numOfTerms = scanner.nextInt();
                    if (numOfTerms < MIN_VALUE) {
                        System.out.println(INVALID_NUF_OF_TERMS_MSG + numOfTerms + HELP_MSG);
                        continue;
                    }
                    break;
                } else {
                    scanner.next();
                    System.out.println(SYMBOL_NOT_INT_MSG + HELP_MSG);
                }
            }
        } catch (Exception e) {
            throw new ConsoleReaderException(e.getMessage());
        }

        return numOfTerms;
    }

}
