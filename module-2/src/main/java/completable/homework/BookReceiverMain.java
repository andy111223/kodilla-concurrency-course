package completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static util.SleepUtil.sleep;

public class BookReceiverMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final CompletableFuture<Book> bookFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Receiving book in process...");
            sleep(4);
            Book book = new Book();
            System.out.println("Book received");
            return book;
        });

        bookFuture
                .thenApply(book -> {
                    System.out.println("Adding ginature in process..");
                    sleep(2);
                    book.setSignature("Signed by John Doe");
                    System.out.println("Signature added");
                    return book;
                })
                .thenAccept(book -> System.out.println(book.toString()))
                .get();
    }
}
