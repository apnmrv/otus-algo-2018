package Sorter.InsertionSorter;

import Sorter.ISorter;

public class InsertionSorter implements ISorter {

    @Override
    public void sort(int[] arr) {

        int size = arr.length;

        sort(arr, size);
    }

    public void sort(int[] arr, int size) {

        int i,j,key;

        for(i = 1; i < size; i++) {
            key = arr[i];
            for (j = i-1; 0 <= j && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1] = key;
        }
    }
}
