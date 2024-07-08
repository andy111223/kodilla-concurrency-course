package multi.parallel;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApp {
    public static void main(String[] args) {

        List<Book> books = Books.randomBooks(1000);
        ForkJoinPool thePool = new ForkJoinPool();

        Long result = thePool.invoke(new BookProcessTask(books));

        System.out.println(result);
    }
}
