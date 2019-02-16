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

        int pivotIdx = partitionLikeHoar(lPtr, rPtr);

        sortWithHoar(lPtr, pivotIdx-1);
        sortWithHoar(pivotIdx+1, rPtr);
    }

    public int partitionLikeLomuto(int lPtr, int rPtr) {

        int pivot = __arr[rPtr];
        int idx = lPtr;

        for (int j = lPtr; j < rPtr; j++) {
            if (__arr[j] <= pivot){
                swap(idx, j);
                idx++;
            }
        }
        swap(idx, rPtr);

        return idx;
    }

    public int partitionLikeHoar(int idx1, int idx2) {
        int pivotIdx = (idx1+idx2)/2;
        int pivot = __arr[(idx1+idx2)/2];
        swap(idx1, pivotIdx);

        int i = idx1;
        int j = idx2+1;

        while(true){
            do
                i++;
            while (__arr[i] < pivot && i < idx2);

            do
                j--;
            while(__arr[j] > pivot && j > idx1);

            if (i >= j)
                break;

            swap(i, j);
        }
        swap(idx1, j);
        return j;
    }


    private void swap(int idx1, int idx2) {
        int tmp = __arr[idx1];
        __arr[idx1] = __arr[idx2];
        __arr[idx2] = tmp;
    }
}
