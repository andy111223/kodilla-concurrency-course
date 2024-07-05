package multi.sum;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[1000];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = 1;
        }
        Reducer reducer = new Reducer();
        PartialCalc p1 = new PartialCalc(reducer, anArray, 0, 500);
        PartialCalc p2 = new PartialCalc(reducer, anArray, 500, 1000);
        p1.start(); //thread
        p2.start(); //thread
        /*
        Thread start() method is a non-blocking method, so before the calculation in a thread is finished
        program continues to the next line: System.out.println(reducer.getCounter(). Use join() method
        to wait until thread completes before going on to the next line of code.
         */
        p1.join();
        p2.join();
        System.out.println(reducer.getCounter());
    }
}
