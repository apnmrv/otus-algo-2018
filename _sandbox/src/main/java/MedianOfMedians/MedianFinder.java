package MedianOfMedians;

public class MedianFinder {

    public int median(int[] array){
        int [] arr = array.clone();
        return __findMedian(arr, 0,arr.length - 1, (arr.length)/2 + 1);
    }

    private int __findMedian(int [] arr, int lo, int hi, int k){

        // Вернуть значение для массивов из 1-го эл-та
        if (lo == hi)
            return arr[lo];

        // Разделить на 3 части относительно медианы и получить ее индекс
        int medianIdx = __partitionByMedianOfMediansValue(arr, lo, hi);

        // Определить размер левого подмассива
        int size = medianIdx - lo + 1;

        // Если искомый элемент --- медиана, вернуть значение
        if( k == size )
            return arr[medianIdx];

        // Если искомый элемент меньше медианы, повторить все для левого подмассива
        else if( k < size )
            return __findMedian(arr, lo, medianIdx - 1, k);

        // Если искомый элемент больше медианы, повторить все для правого подмассива
        else
            return __findMedian(arr, medianIdx + 1, hi, k - size );
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
        if(hi - lo + 1 < 10){
            ArrayHelper.sort(arr);
            return arr[arr.length/2];
        }

        // Иначе, разбить на подмассивы по 5 элементов, найти медианы и собрать в массив медиан
        int mediansCount = (hi - lo + 1)/5;
        mediansCount =  (hi - lo + 1)%5 == 0 ? mediansCount : mediansCount+1;
        int [] medians = new int [mediansCount];


        int loIdx, hiIdx;
        loIdx = lo;

        for ( int i = 0 ; i < mediansCount ; i ++ ){
            hiIdx = loIdx + 4 <= hi ? loIdx + 4 : hi;
            __sortSubArray(arr, loIdx, hiIdx);
            medians[i] = arr[loIdx + (hiIdx - loIdx)/2];
            loIdx = hiIdx+1;
        }
        return __medianOfMedians(medians, 0, mediansCount - 1);
    }

    private void __sortSubArray(int [] arr, int lo, int hi){
        int i, j, tmp;

        for (i = lo + 1; i <= hi; i++) {
            tmp = arr[i];
            for (j = i - 1; 0 <= j && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }
}
