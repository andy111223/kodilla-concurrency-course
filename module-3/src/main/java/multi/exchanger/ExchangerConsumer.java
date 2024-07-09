package multi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerConsumer implements Runnable {

    private Exchanger<String> exchanger;

    public ExchangerConsumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                String msg = exchanger.exchange("");
                System.out.println(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
