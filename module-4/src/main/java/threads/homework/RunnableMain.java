package threads.homework;

public class RunnableMain {
    public static void main(String[] args) {

        createThread(1);

    }

    private static void createThread(int num) {

        // Threads are created and started recursively using lambda expressions

        Runnable runnable = () -> {
            System.out.println("Hello from Thread number: " + num);
            if (num != 50) {
                createThread(num + 1);
            }

        };

        // Runnable interface with a lambda expression passed to the Thread constructor

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
