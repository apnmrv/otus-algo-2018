package Sorter.CountingSorter;

import Sorter.ISorter;

public class CSorter implements ISorter {

    private int[] __array;
    private int[] __count;
    private int __size;
    private int __min;
    private int __max;
    private int __offset;

    CSorter(){
        __offset = 0;
    }

    @Override
    public void sort(int[] array){
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
        int k = 0;
        if (__min == __max)
            return;
        if(0 == __offset) {
            for(int i = 0; i <= __max; i++){
                if( 0 == __count[i] ) {
                    continue;
                } else if (1 == __count[i]) {
                    __array[k++] = i;
                } else {
                    for(int j = 0; j < __count[i]; j++) {
                        __array[k++] = i;
                    }
                }
            }
        } else {
            for(int i = 0; i <= __max + __offset; i++){
                if(0 == __count[i]) {
                    continue;
                } else if (1 == __count[i]) {
                    __array[k++] = i - __offset;
                } else {
                    for(int j = 0; j < __count[i]; j++) {
                        __array[k++] = i - __offset;
                    }
                }
            }
        }
    }

    private void __count() {
        if(0 == __offset) {
            __count = new int [ __max + 1 ];
            for(int a : __array){
                __count[a]++;
            }
        } else {
            __count = new int [ __max + __offset + 1 ];
            for(int a : __array){
                __count[a + __offset]++;
            }
        }
    }

    private void __setInputDataParams() throws Exception {
        __min = __array[0];
        __max = __array[0];
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

        if((__max + __offset + 1) > __size) {
            throw new Exception("Improper data");
        }
    }
}
