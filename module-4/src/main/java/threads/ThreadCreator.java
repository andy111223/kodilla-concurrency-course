package threads;
/*
Recursive thread creation mechanism in Java.
The ThreadCreator class extends the Thread class, making it a subclass that can run in its own thread.
 */
public class ThreadCreator extends Thread {

    private final int num;

    public ThreadCreator(int num) {
        this.num = num;
    }
/*
The run() method is overridden from the Thread class. This is the entry point of the thread when it is started.
If the current thread number (num) is not 50,
it creates a new instance of ThreadCreator with the next number (num + 1) and starts it.
 */
    @Override
    public void run() {
        System.out.println("Hello from Thread number: " + num);
        if (num != 50) {
            final Thread thread = new ThreadCreator(num + 1);
            thread.start();
        }
    }
}
