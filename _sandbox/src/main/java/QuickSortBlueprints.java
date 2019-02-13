public class QuickSortBlueprints {

    private int [] __arr;
    private int __pivotIdx;

    public int getPreparedArray(int [] array) {
        __arr = array;
        __pivotIdx = array.length-1;
        int lPtr = 0;
        int rPtr = __pivotIdx-1;

        while(true){
            while(__arr[lPtr] < __arr[__pivotIdx])
                lPtr++;

            while(__arr[rPtr] > __arr[__pivotIdx])
                rPtr++;

            if( lPtr >= rPtr )
                break;
            else
                swap(lPtr, rPtr);
        }

        swap(lPtr, __pivotIdx);
        return lPtr;
    }

    private void swap(int idx1, int idx2) {
        int tmp = __arr[idx1];
        __arr[idx1] = __arr[idx2];
        __arr[idx2] = tmp;
    }
}
