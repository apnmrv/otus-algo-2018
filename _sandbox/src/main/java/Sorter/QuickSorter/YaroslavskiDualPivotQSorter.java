package Sorter.QuickSorter;

import Sorter.ArrayHelper;

public class YaroslavskiDualPivotQSorter extends OptimizedQSorter {

    private static final int DIVISOR = 3;
    private static final int INSERTION_CUTOFF = 27;
    private int pivot1;
    private int pivot2;

    YaroslavskiDualPivotQSorter() {
        super(new HoareSplitter(), INSERTION_CUTOFF);
    }

    @Override
    protected void doSort(int fromIndex, int toIndex) {
        __rangeCheck(_array.length, fromIndex, toIndex);
        __dualPivotQuicksort(_array, fromIndex, toIndex, DIVISOR);
    }

    private void __dualPivotQuicksort(int[] a, int left, int right, int div) {

        int len = right - left;
        if (len < 27) {
            doInsertionSort(left, right);
            return;
        }
        int third = len / div;

        __setPivots(a, left, right, third);

        int less = left + 1;
        int great = right - 1;

        // sorting
        for (int k = less; k <= great; k++) {
            if (a[k] < pivot1) {
                ArrayHelper.swap(a, k, less++);
            }
            else if (a[k] > pivot2) {
                while (k < great && a[great] > pivot2) {
                    great--;
                }
                ArrayHelper.swap(a, k, great--);
                if (a[k] < pivot1) {
                    ArrayHelper.swap(a, k, less++);
                }
            }
        }
        // swaps
        int dist = great - less;
        if (dist < 13) {
            div++;
        }
        ArrayHelper.swap(a, less - 1, left);
        ArrayHelper.swap(a, great + 1, right);
        // subarrays
        __dualPivotQuicksort(a, left, less - 2, div);
        __dualPivotQuicksort(a, great + 2, right, div);

        // equal elements
        if (dist > len - 13 && pivot1 != pivot2) {
            for (int k = less; k <= great; k++) {
                if (a[k] == pivot1) {
                    ArrayHelper.swap(a, k, less++);
                }
                else if (a[k] == pivot2) {
                    ArrayHelper.swap(a, k, great--);
                    if (a[k] == pivot1) {
                        ArrayHelper.swap(a, k, less++);
                    }
                }
            }
        }
        // subarray
        if (pivot1 < pivot2) {
            __dualPivotQuicksort(a, less, great, div);
        }

    }

    private void __setPivots(int[] a, int left, int right, int third) {
        int m1 = left + third;
        int m2 = right - third;
        if (m1 <= left) {
            m1 = left + 1;
        }
        if (m2 >= right) {
            m2 = right - 1;
        }
        if (a[m1] < a[m2]) {
            ArrayHelper.swap(a, m1, left);
            ArrayHelper.swap(a, m2, right);
        }
        else {
            ArrayHelper.swap(a, m1, right);
            ArrayHelper.swap(a, m2, left);
        }
        pivot1 = a[left];
        pivot2 = a[right];
    }

    private void __rangeCheck(int length, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex > toIndex");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > length) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }
}
