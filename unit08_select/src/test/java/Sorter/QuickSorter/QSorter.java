package Sorter.QuickSorter;

abstract class QSorter implements ISorter {
    protected ISplitter _splitter;
    protected int [] _array;

    QSorter(ISplitter splitter){
        _splitter = splitter;
    }

    public void sort(int[] array) {
        _array = array;
        doSort(0, _array.length-1);
    }

    abstract protected void doSort(int idxFrom, int idxTo);

    abstract public String title();
}
