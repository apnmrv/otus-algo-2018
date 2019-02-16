package Sorter.QuickSorter;

public class HoarQSorter extends QSorter {

    HoarQSorter(ISplitter splitter) {
        super(splitter);
    }

    protected void doSort(int idx1, int idx2){
        if (idx1 >= idx2)
            return;

        int pivotIdx = _splitter.split(_array, idx1, idx2);

        doSort(idx1, pivotIdx-1);
        doSort(pivotIdx+1, idx2);
    }
}
