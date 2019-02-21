package Sorter.SimplifiedBucketSorter;

public class Bucket {
    private int [] __elements;
    private int __size;

    Bucket(int capacity){
        __size = 0;
        __elements = new int[capacity];
    }

    void add(int number){
        __elements[__size] = number;
        __size++;
    }

    int size(){
        return __size;
    }

    int [] elements(){
        return __elements;
    }
}
