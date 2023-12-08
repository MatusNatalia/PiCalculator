package ru.cft.focus.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

public class Task implements Callable<Double> {

    private static final String TASK_INFO_MSG = "Thread %s starts with %d and calculates %d terms";
    private static final Logger log = LogManager.getLogger(Task.class);
    private final int startIndex;
    private final int numberOfTerms;

    public Task(int startIndex, int numberOfTerms) {
        this.startIndex = startIndex;
        this.numberOfTerms = numberOfTerms;
    }

    @Override
    public Double call() {
        log.info(String.format(TASK_INFO_MSG, Thread.currentThread().getName(), startIndex, numberOfTerms));

        double localResult = 0;
        for (int i = startIndex; i < startIndex + numberOfTerms; i++) {
            if (i % 2 == 0) {
                localResult += 1. / (2 * i + 1);
            } else {
                localResult -= 1. / (2 * i + 1);
            }
        }
        return localResult;
    }

}
