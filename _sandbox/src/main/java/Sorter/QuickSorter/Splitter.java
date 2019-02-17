package Sorter.QuickSorter;

public abstract class Splitter implements ISplitter {

    public abstract int split(int[] arr, int idxFrom, int idxTo, int idxPivot);
}
