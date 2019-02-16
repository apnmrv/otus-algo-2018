package Sorter.QuickSorter;

import Sorter.IArrayHelper;

public class LomutoSplitter extends Splitter {

    public LomutoSplitter(IArrayHelper helper) {
        super(helper);
    }

    @Override
    public int split(int[] arr, int idx1, int idx2) {
        int pivot = arr[idx2];
        int idx = idx1;

        for (int j = idx1; j < idx2; j++) {
            if (arr[j] <= pivot){
                _helper.swap(arr, idx, j);
                idx++;
            }
        }
        _helper.swap(arr, idx, idx2);

        return idx;
    }
}
