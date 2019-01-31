package Benchmark;

public class SingleRunData implements IRunData {
    private String _algorithm;
    private String notes;
    private int [] _sequenceIn;
    private int [] _sequenceOut;
    private long _executionTime;

    public SingleRunData(String algorithm, int[] sequenceIn, int[] sequenceOut, long executionTime) {
        _algorithm = algorithm;
        _sequenceIn = sequenceIn;
        _sequenceOut = sequenceOut;
        _executionTime = executionTime;
    }

    @Override
    public String algorithm() {
        return _algorithm;
    }

    @Override
    public String notes() {
        return notes;
    }

    @Override
    public void addNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int[] sequenceIn() {
        return _sequenceIn;
    }

    @Override
    public int[] sequenceOut() {
        return _sequenceOut;
    }

    @Override
    public long executionTime() {
        return _executionTime;
    }
}
