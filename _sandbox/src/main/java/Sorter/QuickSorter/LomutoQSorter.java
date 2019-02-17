package Sorter.QuickSorter;

public class LomutoQSorter extends QSorter {

    LomutoQSorter() {
        super(new LomutoSplitter());
    }

    protected void doSort(int idxFrom, int idxTo){
        if (idxFrom >= idxTo)
            return;

        int pivotIdx = _splitter.split(_array, idxFrom, idxTo, idxTo);

        doSort(idxFrom, pivotIdx-1);
        doSort(pivotIdx+1, idxTo);
    }
}
