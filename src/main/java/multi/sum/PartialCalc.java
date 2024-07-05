package multi.sum;

public class PartialCalc extends Thread {

    private Reducer reducer;
    private int[] elements;
    private int lowerIndex;
    private int upperIndex;

    public PartialCalc(Reducer reducer, int[] elements, int lowerIndex, int upperIndex) {
        this.reducer = reducer;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }

    @Override
    public void run() {
        for (int n = lowerIndex; n < upperIndex; n++) {
            reducer.add(elements[n]);
        }
    }
}
