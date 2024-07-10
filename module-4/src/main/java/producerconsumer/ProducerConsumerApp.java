package producerconsumer;

public class ProducerConsumerApp {
    public static void main(String[] args) {

        final Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
    }
}
