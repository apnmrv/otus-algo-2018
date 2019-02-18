package Sorter.QuickSorter;

public class HoareQSorter extends QSorter {

    private static final String __TITLE = "Hoare QuickSort";

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

    @Override
    public String title() {
        return __TITLE;
    }
}
