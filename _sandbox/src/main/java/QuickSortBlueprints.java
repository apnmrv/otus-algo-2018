public class QuickSortBlueprints {

    private final int [] __arr;

    QuickSortBlueprints(int [] array) {
        __arr = array;
    }

    public void sortWithLomuto(int lPtr, int rPtr){
        if (lPtr >= rPtr)
            return;

        int pivotIdx = partitionLikeLomuto(lPtr, rPtr);

        sortWithLomuto(lPtr, pivotIdx-1);
        sortWithLomuto(pivotIdx+1, rPtr);
    }

    public void sortWithHoar(int lPtr, int rPtr){
        if (lPtr>=rPtr)
            return;

        int pivotIdx = partitionLikeLomuto(lPtr, rPtr);

        sortWithLomuto(lPtr, pivotIdx);
        sortWithLomuto(pivotIdx, rPtr);
    }

    public int partitionLikeLomuto(int lPtr, int rPtr) {

        int pivot = __arr[rPtr];
        int i = lPtr;

        for (int j = lPtr; j < rPtr; j++) {
            if (__arr[j] < pivot){
                swap(i, j);
                i++;
            }
        }
        swap(i, rPtr);

        return i;
    }

    public int partitionLikeHoar(int lPointer, int rPointer) {
        int pivot = __arr[(lPointer+rPointer)/2];

        int i = lPointer-1;
        int j = rPointer+1;

        while(true){
            do
                i++;
            while (__arr[i] < pivot);

            do
                j--;
            while(__arr[j] > pivot);

            if ( i >= j ) {
                break;
            }
            swap(i, j);
        }
        swap(i, j);
        return j;
    }


    private void swap(int idx1, int idx2) {
        int tmp = __arr[idx1];
        __arr[idx1] = __arr[idx2];
        __arr[idx2] = tmp;
    }
}
