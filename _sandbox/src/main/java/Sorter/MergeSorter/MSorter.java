package Sorter.MergeSorter;

import Sorter.ArrayHelper;
import Sorter.ISorter;

public abstract class MSorter implements ISorter {
    protected final IMerger __merger;
    protected int[] __arr;
    protected int [] __aux;

    MSorter(IMerger merger){
        __merger = merger;
    }

    @Override
    public void sort(int[] array) {
        __arr = array;
        __aux = ArrayHelper.newArray(array.length);
        mergeSort(0, array.length-1);
    }

    abstract void mergeSort(int idx1, int idx2);
}
