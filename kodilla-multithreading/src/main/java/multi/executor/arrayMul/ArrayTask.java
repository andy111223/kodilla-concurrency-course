package multi.executor.arrayMul;

import java.util.Arrays;
import java.util.Random;

public class ArrayTask implements Runnable {

    private static int[] a1;
    private static int[] a2;
    private static long[] resultArray;
    private int start;
    private int end;

    public static void initializeArrays(int size) {
        Random random = new Random();
        a1 = new int[size];
        a2 = new int[size];
        resultArray = new long[size];

        for (int i = 0; i < size; i++) {
            a1[i] = random.nextInt(100);
            a2[i] = random.nextInt(100);
        }
        System.out.println("Initialized array 1: " + Arrays.toString(a1));
        System.out.println("Initialized array 2: " + Arrays.toString(a2));
        System.out.println("---");
    }

    public ArrayTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        /*
        Each instance of ArrayTask calculates a part of array.
        'start' is inclusive index,
        'end' is exclusive index of the array part
         */
        for (int i = start; i < end; i++) {
            synchronized (ArrayTask.class) {
                resultArray[i] = (long) a1[i] * a2[i];
            }
        }
        synchronized (ArrayTask.class) {
            System.out.println(Thread.currentThread().getName() + " finished; part of resultArray[" + start + "-" + end + "] = " + Arrays.toString(Arrays.copyOfRange(resultArray, start, end)));
        }
    }

    public static long[] getResultArray() {
        return resultArray;
    }
}
