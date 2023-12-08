package ru.cft.focus.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.cft.focus.exceptions.PiCalculatorException;

public class PiCalculator {
    private static final String NUM_OF_CORES_MSG = "Available cores: ";
    private static final Logger log = LogManager.getLogger(PiCalculator.class);

    public double calculatePi(int N) {
        int cores = determineNumberOfCores(N);

        int local_N = N / cores;
        Task localtask = new Task(local_N * (cores - 1), N - local_N * (cores - 1));

        if (cores == 1) {
            return 4 * localtask.call();
        } else {
            try (ExecutorService executor = Executors.newFixedThreadPool(cores - 1)) {
                List<Task> tasks = new ArrayList<>();
                for (int core = 0; core < cores - 1; core++) {
                    tasks.add(new Task(local_N * core, local_N));
                }
                var tasksResults = executor.invokeAll(tasks);

                double result = localtask.call();
                for (int core = 0; core < cores - 1; core++) {
                    result += tasksResults.get(core).get();
                }

                return 4 * result;
            } catch (Exception e) {
                throw new PiCalculatorException(e.getMessage());
            }
        }
    }

    private int determineNumberOfCores(int N) {
        int cores = Runtime.getRuntime().availableProcessors();
        log.info(NUM_OF_CORES_MSG + cores);
        if (N < cores) {
            return 1;
        } else {
            return cores - 1;
        }
    }

}
