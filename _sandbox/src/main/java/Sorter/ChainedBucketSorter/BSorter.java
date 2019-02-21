package Sorter.ChainedBucketSorter;

import Sorter.ISorter;
import Sorter.InsertionSorter.InsertionSorter;

public class BSorter implements ISorter {

    private Bucket [] __buckets;
    private int[] __array;
    private InsertionSorter __iSorter;

    @Override
    public void sort(int[] array) {
        __iSorter = new InsertionSorter();
        __array = array;
        BucketFactory bf = new BucketFactory(array);
        __buckets = bf.buckets();
        sortArray();
    }

    private void sortArray() {
        int i = 0;
        for (Bucket bucket : __buckets) {
            if(null == bucket)
                continue;
            int bSize = bucket.size();
            if(1 == bSize) {
                __array[i++] = bucket.first().value();
                continue;
            }
            int [] bArr = bucket.all();
            __iSorter.sort(bArr);
            for(int j = 0; j < bSize; j++){
                __array[i++] = bArr[j];
            }
        }
    }
}
