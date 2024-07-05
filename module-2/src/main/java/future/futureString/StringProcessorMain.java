package future.futureString;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static util.SleepUtil.sleep;

public class StringProcessorMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        StringProcessor stringProcessor = new StringProcessor();

        Future<String> futureResult1 = stringProcessor.process("hello");
        Future<String> futureResult2 = stringProcessor.process("world");

        while (!futureResult1.isDone() || !futureResult2.isDone()) {
            System.out.println("Result1 done: " + futureResult1.isDone());
            System.out.println("Result2 done: " + futureResult2.isDone());
            sleep(1);
        }

        String result1 = futureResult1.get();
        String result2 = futureResult1.get();

        System.out.println("Result1 : " + result1);
        System.out.println("Result2 : " + result2);

        stringProcessor.shutdown();
    }
}
