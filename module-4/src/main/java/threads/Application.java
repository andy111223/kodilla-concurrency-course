package threads;

public class Application {
    public static void main(String[] args) {

        final ThreadCreator threadCreator = new ThreadCreator(1);
        threadCreator.start();
    }
}
/*
Recursion in Thread Creation: The code demonstrates a recursive approach to creating and starting threads.
Each thread creates the next thread in the sequence.

The main method is the entry point of the application.
It creates the first instance of ThreadCreator with the number 1 and starts it.
Recursive Thread Creation:

The first thread prints "Hello from Thread number: 1".
Since the number is not 50, it creates and starts another ThreadCreator thread with the number 2.
This process continues recursively.
 */
