package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");

        try {
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");

        } catch (InterruptedException e) {
            System.out.println("Thead is Interrupted" + e.getMessage());
        }

        var map = new HashMap<String, Integer>();
        map.put("max", maxThread.getMaxVal());
        map.put("min", minThread.getMinVal());

        return map;
    }
    // END
}
