package Benchmark;

import Sorter.ISorter;

public interface IBenchmark {

    IPrintableReport estimateSingleRun(ISorter sorter, int sequenceSize);

    IPrintableReport estimateMultipleRuns(ISorter sorter, int sequenceSize, int times);

    IPrintableReport estimateComplexity(ISorter sorter, int sizeFrom, int sizeTo, int runs);
}
