package Sorter.RadixSort;

import Sorter.ISorter;

public class RSorterBitwise implements ISorter {

    private static final int __STEP = 2;

    private int __size;
    private int[] __array;
    private int[] __count;
    private int __shift;
    private int __min;
    private int __max;
    private int __offset;

    @Override
    public void sort(int[] array) {
        __array = array;
        __size = array.length;
        try {
            __setInputDataParams();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (__shift = 0; __shift < __maxBinarySize()/ __STEP; __shift++){
            __count();
            __sort();
        }
        if(0 != __offset) {
            for(int i = 0 ; i < __size; i++) {
                __array[i] -=__offset;
            }
        }
    }

    private void __count() {
        int cSize  = 1 << __STEP;

        __count = new int[cSize];

        for (int i = 0; i < __size ; i++)
            __count[ (__array[i] >> __STEP * __shift) & ((1 << __STEP)-1) ]++;

        for (int j = 1; j < cSize; j++)
            __count[j] += __count[j-1];
    }

    private void __sort() {

        int [] aux = __array.clone();

        for (int k = __size - 1; k >= 0; k--) {
            __array[ --__count[ (aux[k] >> __shift * __STEP) & ((1 << __STEP)-1) ]] = aux[k];
        }
    }

    private void __setInputDataParams() {
        __min = __array[0];
        __max = __array[0];
        __offset = 0;
        for (int i = 1; i < __size; i++) {
            if(__array[i] < __min){
                __min = __array[i];
                continue;
            }
            if(__array[i] > __max) {
                __max = __array[i];
                continue;
            }
        }
        if(__min < 0)
            __offset = __min * -1;
        for(int i = 0 ; i < __size; i++) {
            __array[i] +=__offset;
        }
    }

    private int __maxBinarySize() {
        int max = __max;
        int size = 1;
        while(max > 0){
            max >>= 1;
            size++;
        };
        return size;
    }
}