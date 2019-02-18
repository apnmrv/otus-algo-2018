package Benchmark;

import Randomizer.IRandomizer;
import Randomizer.Randomizer;
import Sorter.ISorter;

public class Benchmark implements IBenchmark {

    private IRandomizer _randomizer = new Randomizer();
    private ISorter _sorter;
    private String _sortingAlgo;
    private int[] _sequenceOut;
    private int[] _sequenceIn;

    public Benchmark() {    }

    @Override
    public IPrintableReport estimateSingleRun(ISorter sorter, int sequenceSize)
    {
        _sorter = sorter;
        _sortingAlgo = sorter.title();
        _sequenceIn = _randomizer.getRandomSequence(1, sequenceSize, sequenceSize);

        _sequenceOut = _sequenceIn.clone();

        long estimateExecTime = estimateExecTime(_sorter, _sequenceOut);

        IRunData data = new SingleRunData(_sortingAlgo, _sequenceIn, _sequenceOut, estimateExecTime);

        return new SingleRunReport(data);
    }

    @Override
    public IPrintableReport estimateMultipleRuns(ISorter sorter, int sequenceSize, int times) {
        _sorter = sorter;
        _sortingAlgo = sorter.title();

        MultipleRunsData mData = new MultipleRunsData();
        for(int i = 0; i < times; i++){
            _sequenceIn = _randomizer.getRandomSequence(1, sequenceSize, sequenceSize);
            _sequenceOut = _sequenceIn.clone();
            long estimateExecTime = estimateExecTime(_sorter, _sequenceOut);
            IRunData data = new SingleRunData(_sortingAlgo, _sequenceIn, _sequenceOut, estimateExecTime);
            mData.addSingleResultData(data);
        }

        return new MultipleRunsReport(mData);
    }

    @Override
    public IPrintableReport estimateComplexity(ISorter sorter, int sizeFrom, int sizeTo, int runs) {
        _sorter = sorter;
        _sortingAlgo = sorter.title();

        int points = (int)Math.log10(sizeTo/sizeFrom);
        MultipleRunsData [] mDataArray = new MultipleRunsData [points];

        int p = 0;
        int size = sizeFrom;
        while (p < points) {
            MultipleRunsData mData = new MultipleRunsData();
            for(int i = 0; i < runs; i++){
                _sequenceIn = _randomizer.getRandomSequence(1, size, size);
                _sequenceOut = _sequenceIn.clone();
                long estimateExecTime = estimateExecTime(_sorter, _sequenceOut);
                IRunData data = new SingleRunData(_sortingAlgo, _sequenceIn, _sequenceOut, estimateExecTime);
                mData.addSingleResultData(data);
            }
            mDataArray[p] = mData;
            p++;
            size *=10;
        }

        return new MultipleRunsReport(mDataArray);
    }

    private long estimateExecTime(ISorter sorter, int[] sequenceIn) {
        long start = System.nanoTime();
        sorter.sort(sequenceIn);
        long end = System.nanoTime();
        long estimation = end - start;
        return estimation;
    }
}
