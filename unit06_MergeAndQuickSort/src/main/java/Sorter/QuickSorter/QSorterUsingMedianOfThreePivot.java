package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class QSorterUsingMedianOfThreePivot extends OptimizedQSorter {

    private static final String __TITLE = "QuickSort Using 'Median of three' Pivot And Insertion Sort on Small Subarrays";

    public QSorterUsingMedianOfThreePivot(int insertionSortCutoff) {
        super(new HoareSplitter(), insertionSortCutoff);
    }

    @Override
    protected void doSort(int idxFrom, int idxTo) {

        if (idxTo - idxFrom < _cutoff) {
            doInsertionSort(idxFrom, idxTo);
            return;
        }

        applyMedianOfThreeStrategy(idxFrom, idxTo);
        int pivotIdxOut = _splitter.split(_array, idxFrom, idxTo, idxTo);

        doSort(idxFrom, pivotIdxOut-1);
        doSort(pivotIdxOut+1, idxTo);
    }

    private void applyMedianOfThreeStrategy(int idxFrom, int idxTo) {
        int middleIdx = (idxFrom + idxTo)/2;

        if(_array[middleIdx] < _array[idxFrom])
            ArrayHelper.swap(_array, middleIdx, idxFrom);
        if(_array[idxTo] < _array[idxFrom])
            ArrayHelper.swap(_array, idxTo, idxFrom);
        if(_array[idxTo] < _array[middleIdx])
            ArrayHelper.swap(_array, middleIdx, idxTo);

        ArrayHelper.swap(_array, middleIdx, idxTo);
    }

    @Override
    public String title() {
        return __TITLE;
    }
}
