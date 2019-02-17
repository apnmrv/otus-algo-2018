package Sorter.QuickSorter;

import Sorter.ArrayHelper;
import Sorter.InsertionSorter.InsertionSorter;

public abstract class OptimizedQSorter extends QSorter {

    protected final InsertionSorter _iSorter;
    protected final int _cutoff;

    OptimizedQSorter(ISplitter splitter, int insertionSortCutoff) {
        super(splitter);
        _iSorter = new InsertionSorter();
        _cutoff = insertionSortCutoff;
    }

    @Override
    abstract protected void doSort(int idxFrom, int idxTo);

    protected void doInsertionSort(int idxFrom, int idxTo) {
        int [] aux = ArrayHelper.extractSubarray(_array, idxFrom, idxTo);
        _iSorter.sort(aux);
        ArrayHelper.replaceSubarray(_array, aux, idxFrom);
    }
}
