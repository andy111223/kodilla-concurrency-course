package multi.exchanger.book;

import java.util.concurrent.Exchanger;

public class BookExchangerProducer implements Runnable {

    private Exchanger<Book> exchanger;

    public BookExchangerProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
        Book book = new Book("Title " + n, "Author " + n);
            try {
                System.out.println("Produced: " + book.toString());
                exchanger.exchange(book);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
