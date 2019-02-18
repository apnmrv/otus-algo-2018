package Sorter.QuickSorter;

import Sorter.INamed;
import Sorter.ISorter;

abstract class QSorter implements ISorter, INamed {
    protected ISplitter _splitter;
    protected int [] _array;

    QSorter(ISplitter splitter){
        _splitter = splitter;
    }

    @Override
    public void sort(int[] array) {
        _array = array;
        doSort(0, _array.length-1);
    }

    abstract protected void doSort(int idxFrom, int idxTo);

    abstract public String title();
}
