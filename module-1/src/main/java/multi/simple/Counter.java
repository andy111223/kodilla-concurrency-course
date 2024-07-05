package multi.simple;

public class Counter extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//            System.out.println("Object " + hashCode() + ", current value: " + i);
            /* Hashcode can be the same for two objects; use system process id instead:
             */
            System.out.println("Object " + Thread.currentThread().threadId() + ", current value: " + i);
        }
    }
}
