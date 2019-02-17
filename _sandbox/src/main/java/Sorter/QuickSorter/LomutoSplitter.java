package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class LomutoSplitter extends Splitter {

    @Override
    public int split(int[] arr, int idxFrom, int idxTo, int idxPivot) {
        int pivot = arr[idxPivot];
        ArrayHelper.swap(arr, idxPivot, idxTo);
        int idx = idxFrom;

        for (int j = idxFrom; j < idxTo; j++) {
            if (arr[j] <= pivot){
                ArrayHelper.swap(arr, idx, j);
                idx++;
            }
        }
        ArrayHelper.swap(arr, idx, idxTo);

        return idx;
    }
}
