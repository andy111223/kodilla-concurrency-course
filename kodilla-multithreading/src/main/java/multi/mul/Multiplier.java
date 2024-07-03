package multi.mul;

public class Multiplier {

    private int counter = 1;

    public synchronized void multiply(int value) {
        counter *= value;
    }
    public int getCounter() {
        return counter;
    }
}
