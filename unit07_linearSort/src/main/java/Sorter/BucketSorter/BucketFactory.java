package Sorter.BucketSorter;
public class BucketFactory implements IHashCalc {

    private int [] __array;
    private int __size;

    BucketFactory(int [] array){
        __array = array;
        __size = array.length;
    }

    Bucket [] buckets(){
        Bucket [] bckts = new Bucket[__size];
        for (int i = 0; i < __size; i++){
            int bucketId = hash(__array[i]);
            if(null == bckts[bucketId]) {
                bckts[bucketId] = new Bucket();
            }
            bckts[bucketId].append(new Element(__array[i]));
        }
        return bckts;
    }

    @Override
    public int hash(int num) {
        int hash = num/3;
        return hash;
    }
}
