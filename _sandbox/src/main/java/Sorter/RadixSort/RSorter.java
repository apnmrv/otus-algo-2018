package Sorter.RadixSort;

import Sorter.ISorter;

public class RSorter implements ISorter {

    private static int $base = 10;

    private int __size;
    private int[] __array;
    private int[] __count;
    private int __basePower;
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
        for (__basePower = 1; __basePower <= __maxBasePower(); __basePower *= $base){
            __count();
            __sort();
        }
        if(0 != __offset) {
            for(int i = 0 ; i < __size; i++) {
                __array[i] -=__offset;
            }
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

    private int __maxBasePower() {
        int max = __max;
        int power = 1;
        while(max > 0){
            max /= $base;
            power *= $base;
        };
        return power;
    }

    private void __sort() {
        int [] aux = __array.clone();
        for (int k = __size - 1; k >= 0; k--) {
            __array[--__count[(aux[k]/__basePower) % $base]] = aux[k];
        }
    }

    private void __count() {
        __count = new int[$base];
        for (int i = 0; i < __size ; i++)
            __count[(__array[i]/__basePower) % $base]++;

        for (int j = 1; j < $base; j++)
            __count[j] += __count[j-1];
    }
}