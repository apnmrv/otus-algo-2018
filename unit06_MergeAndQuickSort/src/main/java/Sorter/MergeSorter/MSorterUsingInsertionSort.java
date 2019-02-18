package Sorter.MergeSorter;

import Sorter.ArrayHelper;
import Sorter.InsertionSorter.InsertionSorter;

public class MSorterUsingInsertionSort extends MSorter {

    private static final String __TITLE = "MergeSort Implementation Using InsertionSort On Small Subarrays";
    private final InsertionSorter __iSorter;
    private int __insertionSortCutoff;

    public MSorterUsingInsertionSort(IMerger merger, InsertionSorter iSorter,
                                     int insertionSortCutoff) {
        super(merger);
        __insertionSortCutoff = insertionSortCutoff;
        __iSorter = iSorter;
    }

    @Override
    void mergeSort(int firstIdx, int lastIdx) {

        if(lastIdx <= firstIdx + __insertionSortCutoff){
            useInsertionSort(firstIdx, lastIdx);
            return;
        }

        int middleIdx = firstIdx + ( lastIdx - firstIdx ) / 2;

        mergeSort(firstIdx, middleIdx);
        mergeSort(middleIdx+1, lastIdx);
        ArrayHelper.copyElements(__arr, __aux, firstIdx, lastIdx);
        __merger.merge(__arr, __aux, firstIdx, middleIdx, lastIdx);
    }

    @Override
    public String title() {
        return __TITLE;
    }

    private void useInsertionSort(int firstIdx, int lastIdx) {
        int [] arr = ArrayHelper.extractSubarray(__arr, firstIdx, lastIdx);
        __iSorter.sort(arr);
        ArrayHelper.replaceSubarray(__arr, arr, firstIdx);
    }
}
