public class MedianOfMediansSelector implements ISelector {

    MedianOfMediansSelector(){    }

    @Override
    public int select(int[] array, int nSmallestElement) {
        int [] arr = array.clone();
        return __select(arr, 0, arr.length - 1, nSmallestElement);
    }

    private int __select(int[] array, int leftIdx, int rightIdx, int n) {

        if (leftIdx == rightIdx)
            return array[leftIdx];

        int pivotIdx = __partitionByMedianOfMediansValue(array, leftIdx, rightIdx);

        int leftPartitionSize = pivotIdx - leftIdx + 1;

        if (n == leftPartitionSize)
            return array[pivotIdx];

        else if (n < leftPartitionSize)
            return __select(array, leftIdx, pivotIdx - 1 , n);

        else
            return __select(array, pivotIdx + 1, rightIdx, n - leftPartitionSize);
    }

    private int __partitionByMedianOfMediansValue(int[] arr, int lo, int hi) {
        int medianOfMediansValue = __medianOfMedians(arr, lo, hi);

        while(lo < hi){
            while(arr[lo] < medianOfMediansValue)
                lo++;

            while(arr[hi] > medianOfMediansValue)
                hi--;

            if(arr[lo] == arr[hi])
                lo++;

            else if(lo < hi) {
                ArrayHelper.swap(arr, lo, hi);
            }
        }
        return hi;
    }

    private int __medianOfMedians(int[] arr, int lo, int hi) {

        // Вернуть медиану для небольших массивов
        if(hi == lo){
            return arr[lo];
        }

        // Иначе, разбить на подмассивы по 5 элементов, найти медианы и собрать в массив медиан
        int mediansCount = (hi - lo + 1)/5;
        mediansCount =  (hi - lo + 1)%5 == 0 ? mediansCount : mediansCount+1;
        int [] medians = new int [mediansCount];


        int loIdx, hiIdx;
        loIdx = lo;

        for ( int i = 0 ; i < mediansCount ; i ++ ){
            hiIdx = loIdx + 4 <= hi ? loIdx + 4 : hi;
            ArrayHelper.sortSubArray(arr, loIdx, hiIdx);
            medians[i] = arr[loIdx + (hiIdx - loIdx)/2];
            loIdx = hiIdx+1;
        }
        return __medianOfMedians(medians, 0, mediansCount - 1);
    }
}
