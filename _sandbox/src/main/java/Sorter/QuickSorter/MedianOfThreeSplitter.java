package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class MedianOfThreeSplitter implements ISplitter {

    public int split(int[] arr, int idxFrom, int idxTo, int idxPivot) {

        int i = idxFrom - 1;
        int j = idxTo - 1;
        int p = arr[idxPivot];

        while (true) {

            while ( arr[++i] < p ) {
                if ( i == idxTo ) break;
            }

            while ( p < arr[--j] ) {
                if ( j == idxFrom ) break;
            }

            if (i >= j) break;

            ArrayHelper.swap(arr, i, j);
        }

        ArrayHelper.swap(arr, idxTo - 1, j);

        return j;
    }
}
