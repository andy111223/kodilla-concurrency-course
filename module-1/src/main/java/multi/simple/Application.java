package multi.simple;

public class Application {
    public static void main(String[] args) {

//        Counter c1 = new Counter();
//        Counter c2 = new Counter();
//        c1.start();
//        c2.start();

        Thread t1 = new Thread(new CounterRunnable());
        Thread t2 = new Thread(new CounterRunnable());
        t1.start();
        t2.start();
    }
}
