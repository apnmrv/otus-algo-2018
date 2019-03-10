import Randomizer.Randomizer;

public class QuickSelector implements ISelector {

    QuickSelector() { }

    @Override
    public int select(int [] array, int n) {
        int [] arr = array.clone();

        int e = __select(arr, 0, arr.length - 1, n);

        return e;
    }

    private int __select(int[] array, int leftIdx, int rightIdx, int n) {

        int pivotIdx;

        if (leftIdx == rightIdx)
            return array[leftIdx];

        pivotIdx = __split(array, leftIdx, rightIdx);

        int leftPartitionSize = pivotIdx - leftIdx + 1;

        if (n == leftPartitionSize)
            return array[pivotIdx];

        else if (n < leftPartitionSize)
            return __select(array, leftIdx, pivotIdx - 1 , n);

        else
            return __select(array, pivotIdx + 1, rightIdx, n - leftPartitionSize);
    }

    private int __split(int[] arr, int idxFrom, int idxTo){

        int initialPivotIdx = (new Randomizer()).getRandomValue(idxFrom, idxTo);

        int pivotValue = arr[initialPivotIdx];


        ArrayHelper.swap(arr, initialPivotIdx, idxTo);

        int finalPivotIdx = idxFrom;

        for (int i = idxFrom; i < idxTo; i++) {
            if (arr[i] <= pivotValue){
                ArrayHelper.swap(arr, finalPivotIdx, i);
                finalPivotIdx++;
            }
        }
        ArrayHelper.swap(arr, finalPivotIdx, idxTo);

        return finalPivotIdx;
    }
}
