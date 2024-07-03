package multi.mul;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[10];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = n + 1;
        }
        Multiplier multiplier = new Multiplier();
        Thread t1 = new Thread(new PartialCalc(multiplier, anArray, 0, 5));
        Thread t2 = new Thread(new PartialCalc(multiplier, anArray, 5, 10));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(multiplier.getCounter());
    }
}
