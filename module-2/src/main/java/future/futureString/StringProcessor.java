package future.futureString;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.SleepUtil.sleep;

public class StringProcessor {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<String> process(String text) {

        return executor.submit(() ->{
            System.out.println("Processor started processing: " + text);
            sleep(5);
            System.out.println("Processor finished processing: " + text);
            return text.toUpperCase();
        });
    }
    public void shutdown() {
        executor.shutdown();
    }
}
