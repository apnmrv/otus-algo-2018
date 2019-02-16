package Sorter.QuickSorter;

import Sorter.IArrayHelper;

public abstract class Splitter implements ISplitter {

    protected IArrayHelper _helper;

    Splitter(IArrayHelper helper) {
        _helper = helper;
    }

    @Override
    public abstract int split(int[] arr, int idx1, int idx2);
}
