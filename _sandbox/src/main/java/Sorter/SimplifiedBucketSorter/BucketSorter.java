package Sorter.SimplifiedBucketSorter;

import Sorter.ISorter;
import Sorter.InsertionSorter.InsertionSorter;

public class BucketSorter implements ISorter {

    private Bucket [] __buckets;
    private int[] __array;
    private InsertionSorter __iSorter;

    @Override
    public void sort(int[] array) {
        __iSorter = new InsertionSorter();
        __array = array;
        __buckets = new Bucket[array.length];
        arrayToBuckets();
        bucketsToArray();
    }

    private void bucketsToArray() {
        int i = 0;
        for(Bucket b : __buckets){
            if(null == b)
                continue;
            int size = b.size();
            if(1 == size){
                __array[i] = b.elements()[0];
                i++;
            } else {
                __iSorter.sort(b.elements(), size);
                for (int j = 0; j < size; j++) {
                    __array[i] = b.elements()[j];
                    i++;
                }
            }
        }
    }

    private void arrayToBuckets() {
        for(int e : __array) {
            int hash = hash(e);
            if(null == __buckets[hash]){
                __buckets[hash] = new Bucket(__array.length);
            }
            __buckets[hash].add(e);
        }
    }

    private int hash(int e) {
        return e/3;
    }
}
