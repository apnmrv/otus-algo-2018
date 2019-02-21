package Sorter.ChainedBucketSorter;

public class Bucket {
    private Element __firstElement = null;
    private int __size = 0;

    Bucket(){}

    void append(Element element){
        element.setNext(__firstElement);
        __firstElement = element;
        __size++;
    }

    int size(){
        return __size;
    }

    Element first() {
        Element e = null;
        if(null != __firstElement){
            e = __firstElement;
            __firstElement = __firstElement.next();
            __size--;
        }
        return e;
    }

    int [] all(){
        int [] arr = new int [__size];
        int i = 0;
        while(0 < __size){
            arr[i++] = first().value();
        }
        return arr;
    }
}
