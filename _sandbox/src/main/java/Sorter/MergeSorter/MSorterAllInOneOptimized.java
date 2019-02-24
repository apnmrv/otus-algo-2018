package Sorter.MergeSorter;

import Sorter.ArrayHelper;
import Sorter.InsertionSorter.InsertionSorter;

public class MSorterAllInOneOptimized extends MSorter {

    private final InsertionSorter __iSorter;
    private int __insertionSortCutoff;


    MSorterAllInOneOptimized(IMerger merger, InsertionSorter iSorter, int insertionSortCutoff) {
        super(merger);
        __insertionSortCutoff = insertionSortCutoff;
        __iSorter = iSorter;
    }

    void mergeSort(int firstIdx, int lastIdx) {

        ArrayHelper.copyElements(__arr, __aux, firstIdx, lastIdx);

        mergeSort(__arr, __aux, firstIdx, lastIdx);
    }

    private void mergeSort(int[] arrOut, int[] arrIn, int firstIdx, int lastIdx) {
        if(lastIdx < firstIdx + __insertionSortCutoff){
            insertionSort(arrOut, firstIdx, lastIdx);
            return;
        }

        int middleIdx = firstIdx + ( lastIdx - firstIdx ) / 2;

        mergeSort(arrIn, arrOut, firstIdx, middleIdx);
        mergeSort(arrIn, arrOut, middleIdx+1, lastIdx);

        if(arrIn[middleIdx] > arrIn[middleIdx+1])
            __merger.merge(arrOut, arrIn, firstIdx, middleIdx, lastIdx);
    }

    private void insertionSort(int [] arr, int firstIdx, int lastIdx) {
        int [] aux = ArrayHelper.extractSubarray(arr, firstIdx, lastIdx);
        __iSorter.sort(aux);
        ArrayHelper.replaceSubarray(arr, aux, firstIdx);
    }
}
