public class Selector implements ISelector {

    private Splitter __splitter;
    private int[] __array;

    Selector() {
        __splitter = new Splitter();
    }

    @Override
    public int select(int [] array, int nSmallestElementIdx) {
        __array = array.clone();

        int e = __select(__array, 0, __array.length - 1, nSmallestElementIdx);

        return e;
    }

    private int __select(int[] array, int leftIdx, int rightIdx, int nSmallestElementIdx) {

        int pivotIdx;

        if (leftIdx == rightIdx)
            return array[leftIdx];

        pivotIdx = __splitter.split(array, leftIdx, rightIdx);

        int leftPartitionSize = pivotIdx - leftIdx + 1;

        if (nSmallestElementIdx == leftPartitionSize)
            return array[pivotIdx];

        else if (nSmallestElementIdx < leftPartitionSize)
            return __select(array, leftIdx, pivotIdx - 1 , nSmallestElementIdx);

        else
            return __select(array, pivotIdx + 1, rightIdx, nSmallestElementIdx - leftPartitionSize);
    }
}
