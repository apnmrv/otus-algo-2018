package Sorter.MergeSorter;

import Sorter.ArrayHelper;

public class MSorterBasic extends MSorter {

    MSorterBasic(IMerger merger) {
        super(merger);
    }

    void mergeSort(int firstIdx, int lastIdx) {

        if( lastIdx <= firstIdx ) return ;

        int middleIdx = firstIdx + ( lastIdx - firstIdx ) / 2;
        mergeSort(firstIdx, middleIdx);
        mergeSort(middleIdx+1, lastIdx);

        ArrayHelper.copyElements(__arr, __aux, firstIdx, lastIdx);
        __merger.merge(__arr, __aux, firstIdx, middleIdx, lastIdx);
    }
}