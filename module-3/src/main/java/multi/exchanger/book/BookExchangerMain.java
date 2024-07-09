package multi.exchanger.book;

import java.util.concurrent.Exchanger;

public class BookExchangerMain {
    public static void main(String[] args) {

        Exchanger<Book> exchanger = new Exchanger<>();

        Thread producerThread = new Thread(new BookExchangerConsumer(exchanger));
        Thread consumerThread = new Thread(new BookExchangerProducer(exchanger));

        producerThread.start();
        consumerThread.start();
    }
}
