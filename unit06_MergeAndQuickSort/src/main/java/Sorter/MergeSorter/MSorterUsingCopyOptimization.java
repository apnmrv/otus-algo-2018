package Sorter.MergeSorter;

import Sorter.ArrayHelper;
import Sorter.INamed;

public class MSorterUsingCopyOptimization extends MSorter {

    private String __TITLE = "MergeSort Implementation Using Subarrays Copy Optimization";

    public MSorterUsingCopyOptimization(IMerger merger) {
        super(merger);
    }

    void mergeSort(int firstIdx, int lastIdx) {

        ArrayHelper.copyElements(__arr, __aux, firstIdx, lastIdx);

        mergeSort(__arr, __aux, firstIdx, lastIdx);
    }

    private void mergeSort(int[] arrOut, int[] arrIn, int firstIdx, int lastIdx) {
        if( lastIdx <= firstIdx ) return ;

        int middleIdx = firstIdx + ( lastIdx - firstIdx ) / 2;
        mergeSort(arrIn, arrOut, firstIdx, middleIdx);
        mergeSort(arrIn, arrOut, middleIdx+1, lastIdx);

        __merger.merge(arrOut, arrIn, firstIdx, middleIdx, lastIdx);
    }

    @Override
    public String title() {
        return __TITLE;
    }
}