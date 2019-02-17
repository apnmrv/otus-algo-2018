package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class QSorterUsingMedianOfThreePivot extends OptimizedQSorter {

    QSorterUsingMedianOfThreePivot(int insertionSortCutoff) {
        super(new MedianOfThreeSplitter(), insertionSortCutoff);
    }

    @Override
    protected void doSort(int idxFrom, int idxTo) {

        if (idxTo - idxFrom + 1 > _cutoff) {
            doInsertionSort(idxFrom, idxTo);
            return;
        }

        applyMedianOfThreeStrategy(idxFrom, idxTo);
        int pivotIdxOut = _splitter.split(_array, idxFrom, idxTo, idxTo-1);

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

        ArrayHelper.swap(_array, middleIdx, idxTo-1);
    }
}
