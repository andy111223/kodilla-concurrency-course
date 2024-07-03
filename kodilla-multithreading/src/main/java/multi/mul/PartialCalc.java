package multi.mul;

public class PartialCalc implements Runnable {

    private Multiplier multiplier;
    private int[] elements;
    private int lowerIndex;
    private int upperIndex;

    public PartialCalc(Multiplier multiplier, int[] elements, int lowerIndex, int upperIndex) {
        this.multiplier = multiplier;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }
    
    @Override
    public void run() {
        for (int i = lowerIndex; i < upperIndex; i++) {
            multiplier.multiply(elements[i]);
        }
    }
}
