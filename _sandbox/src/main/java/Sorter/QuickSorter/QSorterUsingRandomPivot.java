package Sorter.QuickSorter;

public class QSorterUsingRandomPivot extends OptimizedQSorter {

    QSorterUsingRandomPivot(int insertionSortCutoff) {
        super(new HoareSplitter(), insertionSortCutoff);
    }

    @Override
    protected void doSort(int idxFrom, int idxTo) {

        if (idxTo - idxFrom + 1 > _cutoff) {
            doInsertionSort(idxFrom, idxTo);
            return;
        }

        int pivotIdxIn = calcPivotIdx(idxFrom, idxTo);
        int pivotIdxOut = _splitter.split(_array, idxFrom, idxTo, pivotIdxIn);

        doSort(idxFrom, pivotIdxOut-1);
        doSort(pivotIdxOut+1, idxTo);
    }

    private int calcPivotIdx(int min, int max) {
        return (int) (Math.random()*((max-min)+1))+min;
    }
}
