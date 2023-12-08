package ru.cft.focus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.cft.focus.calculator.PiCalculator;
import ru.cft.focus.reader.ConsoleReader;
import ru.cft.focus.reader.Reader;
import ru.cft.focus.writers.ConsoleWriter;
import ru.cft.focus.writers.Writer;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Reader reader = new ConsoleReader();
            PiCalculator piCalculator = new PiCalculator();
            Writer writer = new ConsoleWriter();
            writer.writeResult(piCalculator.calculatePi(reader.readInputParameter()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}