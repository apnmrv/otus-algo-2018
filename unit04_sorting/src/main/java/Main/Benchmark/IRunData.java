package Main.Benchmark;

public interface IRunData {
    String algorithm();

    String notes();

    void addNotes(String notes);

    int[] sequenceIn();

    int[] sequenceOut();

    long executionTime();
}
