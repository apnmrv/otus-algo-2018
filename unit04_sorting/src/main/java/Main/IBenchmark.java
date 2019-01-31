package Main;

import Main.Benchmark.IPrintableReport;

public interface IBenchmark {

    IPrintableReport estimateSingleRun(ISorter sorter, int sequenceSize);

    IPrintableReport estimateMultipleRuns(ISorter sorter, int sequenceSize, int times);
}
