package Sorter.MergeSorter;

import Sorter.ArrayHelper;
import Sorter.INamed;

public class MSorterAccountingAlreadySorted extends MSorter {

    private static final String __TITLE = "MergeSort Implementation Accounting Already Sorted Subarrays";

    public MSorterAccountingAlreadySorted(IMerger merger) {
        super(merger);
    }

    @Override
    void mergeSort(int firstIdx, int lastIdx) {

        if (lastIdx == firstIdx) return;

        int middleIdx = firstIdx + ( lastIdx - firstIdx ) / 2;

        mergeSort(firstIdx, middleIdx);
        mergeSort(middleIdx+1, lastIdx);

        ArrayHelper.copyElements(__arr, __aux, firstIdx, lastIdx);
        if(__arr[middleIdx] > __arr[middleIdx+1])
            __merger.merge(__arr, __aux, firstIdx, middleIdx, lastIdx);
    }

    @Override
    public String title() {
        return __TITLE;
    }
}
