package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class HoareQSorter extends QSorter {

    public HoareQSorter() {
        super(new HoareSplitter());
    }

    protected void doSort(int idxFrom, int idxTo){
        if (idxFrom >= idxTo)
            return;

        int someIdx = idxFrom +((idxTo - idxFrom)/2);

        int pivotIdx = _splitter.split(_array, idxFrom, idxTo, someIdx);

        doSort(idxFrom, pivotIdx-1);
        doSort(pivotIdx+1, idxTo);
    }
}
