package Benchmark;

import Main.IRandomizer;
import Main.ISorter;
import Main.Randomizer;

public class Benchmark implements IBenchmark {

    private IRandomizer _randomizer;
    private ISorter _sorter;
    private String _sortingAlgo;
    private int[] _sequenceOut;
    private int[] _sequenceIn;

    public Benchmark() {
        this._randomizer = new Randomizer();
    }

    @Override
    public IPrintableReport estimateSingleRun(ISorter sorter, int sequenceSize)
    {
        _sorter = sorter;
        _sortingAlgo = sorter.title();
        _sequenceIn = _randomizer.getIntegers(1, sequenceSize, sequenceSize);

        long estimateExecTime = estimateExecTime(_sorter, _sequenceIn.clone());

        IRunData data = new SingleRunData(_sortingAlgo, _sequenceIn, _sequenceOut, estimateExecTime);

        return new SingleRunReport(data);
    }

    @Override
    public IPrintableReport estimateMultipleRuns(ISorter sorter, int sequenceSize, int times) {
        _sorter = sorter;
        _sortingAlgo = sorter.title();
        int[] sequenceIn = null;
        MultipleRunsData mData = new MultipleRunsData();
        for(int i = 0; i < times; i++){
            _sequenceIn = _randomizer.getIntegers(1, sequenceSize, sequenceSize);
            long estimateExecTime = estimateExecTime(_sorter, _sequenceIn.clone());
            IRunData data = new SingleRunData(_sortingAlgo, _sequenceIn, _sequenceOut, estimateExecTime);
            mData.addSingleResultData(data);
        }

        return new MultipleRunsReport(mData);
    }

    private long estimateExecTime(ISorter sorter, int[] sequenceIn) {
        long start = System.nanoTime();
        _sequenceOut = sorter.sort(sequenceIn);
        long end = System.nanoTime();
        long estimation = end - start;
        return estimation;
    }
}
