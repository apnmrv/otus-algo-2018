package Sorter.CountingSorter;

import Sorter.ISorter;

public class CSorter implements ISorter {

    private int[] __array;
    private int[] __count;
    private int __size;
    private int __min;
    private int __max;
    private int __offset;

    CSorter() {
    }

    @Override
    public void sort(int[] array) {
        __array = array;
        __size = array.length;
        try {
            __setInputDataParams();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        __count();
        __sort();
    }

    private void __sort() {
        if (__min == __max)
            return;
        int[] aux = __array.clone();
        for (int i = 1; i <= __max + __offset; i++)
            __count[i] += __count[i - 1];
        for (int j = __size - 1; j >= 0; j--)
            __array[--__count[aux[j] + __offset]] = aux[j];
    }

    private void __count() {
        __count = new int[__max + __offset + 1];

        for (int a : __array) {
            __count[a + __offset]++;
        }
    }

    private void __setInputDataParams() {
        __offset = 0;
        __min = __array[0];
        __max = __array[0];

        for (int i = 1; i < __size; i++) {
            if (__array[i] < __min) {
                __min = __array[i];
                continue;
            }
            if (__array[i] > __max) {
                __max = __array[i];
                continue;
            }
        }
        if (__min < 0)
            __offset = __min * -1;
    }
}