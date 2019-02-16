package Sorter.QuickSorter;

import Sorter.IArrayHelper;

public class HoarSplitter extends Splitter {

    HoarSplitter(IArrayHelper helper) {
        super(helper);
    }

    public int split(int[] arr, int start, int finish) {
        int i = start;
        int j = finish + 1;
        int p = arr[start];
        while (true) {

            while (arr[++i] < p) {
                if (i == finish) break;
            }

            while (p < arr[--j]) {
                if (j == start) break;
            }

            if (i >= j) break;

            _helper.swap(arr, i, j);
        }

        _helper.swap(arr, start, j);

        return j;
    }
}
