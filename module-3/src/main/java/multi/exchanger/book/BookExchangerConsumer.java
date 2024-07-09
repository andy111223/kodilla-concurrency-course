package multi.exchanger.book;

import java.util.concurrent.Exchanger;

public class BookExchangerConsumer implements Runnable {

    private Exchanger<Book> exchanger;

    public BookExchangerConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                Book book = null;
                book = exchanger.exchange(book);
                System.out.println("Consumed: " + book.toString());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
