package Sorter.QuickSorter;

import Sorter.ArrayHelper;
import Sorter.IArrayHelper;
import Sorter.ISorter;

abstract class QSorter implements ISorter {

    protected IArrayHelper _helper;
    protected ISplitter _splitter;
    protected int [] _array;

    QSorter(ISplitter splitter){
        _splitter = splitter;
        _helper = new ArrayHelper();
    }

    @Override
    public void sort(int[] array) {
        _array = array;
        doSort(0, _array.length-1);
    }

    abstract protected void doSort(int idx1, int idx2);
}
