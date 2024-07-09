package multi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerApp {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        new ExchangerConsumer(exchanger);
        new ExchangerProducer(exchanger);
    }
}
