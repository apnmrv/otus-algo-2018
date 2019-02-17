package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class HoareSplitter extends Splitter {

    public int split(int[] arr, int idxFrom, int idxTo, int idxPivot) {
        int i = idxFrom;
        int j = idxTo + 1;
        int p = arr[idxPivot];
        ArrayHelper.swap(arr, idxFrom, idxPivot);

        while (true) {

            while (arr[++i] < p) {
                if (i == idxTo) break;
            }

            while (p < arr[--j]) {
                if (j == idxFrom) break;
            }

            if (i >= j) break;

            ArrayHelper.swap(arr, i, j);
        }

        ArrayHelper.swap(arr, idxFrom, j);

        return j;
    }
}
