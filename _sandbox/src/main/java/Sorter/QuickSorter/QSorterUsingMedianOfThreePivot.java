package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class QSorterUsingMedianOfThreePivot extends OptimizedQSorter {

    public QSorterUsingMedianOfThreePivot(int insertionSortCutoff) {
        super(new HoareSplitter(), insertionSortCutoff);
    }

    @Override
    protected void doSort(int idxFrom, int idxTo) {

        if(idxFrom >= idxTo)
            return;

        applyMedianOfThree(idxFrom, idxTo);
        int pivotIdx = _splitter.split(_array, idxFrom, idxTo, idxTo);


        doSort(idxFrom, pivotIdx-1);
        doSort(pivotIdx+1, idxTo);
    }

    private void applyMedianOfThree(int idxFrom, int idxTo) {
        int middleIdx = (idxFrom + idxTo)/2;

        if(_array[middleIdx] < _array[idxFrom])
            ArrayHelper.swap(_array, middleIdx, idxFrom);
        if(_array[idxTo] < _array[idxFrom])
            ArrayHelper.swap(_array, idxTo, idxFrom);
        if(_array[idxTo] < _array[middleIdx])
            ArrayHelper.swap(_array, middleIdx, idxTo);

        ArrayHelper.swap(_array, middleIdx, idxTo);
    }
}
