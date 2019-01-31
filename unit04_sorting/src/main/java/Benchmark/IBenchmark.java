package Benchmark;

import Main.ISorter;

public interface IBenchmark {

    IPrintableReport estimateSingleRun(ISorter sorter, int sequenceSize);

    IPrintableReport estimateMultipleRuns(ISorter sorter, int sequenceSize, int times);
}
