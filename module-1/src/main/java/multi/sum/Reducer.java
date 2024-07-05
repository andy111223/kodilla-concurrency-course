package multi.sum;

public class Reducer {

    private int counter;

    /*
    'synchronized' prevents access of a thread to access the counter variable
    (common resource for both threads) while other thread is using it;
    it allows for sequential usage of the method;
    it prevents a loss of counter value due to mutual access to counter by two threads ('race condition');
    code that needs synchronization is 'critical section'
     */
    public synchronized void add(int value) {
        counter += value;
    }
    public int getCounter() {
        return counter;
    }
}
