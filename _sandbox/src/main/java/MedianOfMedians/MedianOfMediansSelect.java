package MedianOfMedians;

public class MedianOfMediansSelect implements ISelector {

    @Override
    public int select( int[] array, int nSmallestElement ) {
        int [] arr = array.clone();

        return __select( arr, 0, array.length-1, nSmallestElement );
    }

    private int __select( int[] arr, int lo, int hi, int nSmallestElement ) {
        if( lo == hi )
            return lo;
        int pivotIdx = __pivot( arr, lo, hi );
        pivotIdx = __partition( arr, lo, hi, pivotIdx, nSmallestElement );

        if( nSmallestElement - 1 == pivotIdx - lo )
            return arr[nSmallestElement];
        else if ( nSmallestElement - 1 < pivotIdx - lo )
            return __select(arr, lo, pivotIdx - 1, nSmallestElement);

        return __select(arr, pivotIdx + 1, hi, nSmallestElement - ( pivotIdx + 1 ) + lo);
    }

    private int __partition(int [] arr, int lo, int hi, int pivotIdx, int n){

        int i;
        int pivotValue = arr[pivotIdx];

        // set pivot aside
        ArrayHelper.swap(arr, pivotIdx, hi);

        // Collecting less than pivot value
        int greatestFromTheLessThanThePivotIdx = lo;
        for ( i = lo; i < hi; i++ ) {
            if( arr[i] < pivotValue) {
                ArrayHelper.swap(arr, greatestFromTheLessThanThePivotIdx, i);
                greatestFromTheLessThanThePivotIdx++;
            }
        }

        // Collecting equals to pivot value
        int greatestFromTheEqualsToPivotIdx = greatestFromTheLessThanThePivotIdx;
        for( i = greatestFromTheLessThanThePivotIdx; i < hi; i++ ) {
            if( arr[i] == pivotValue) {
                ArrayHelper.swap(arr, greatestFromTheEqualsToPivotIdx, i);
                greatestFromTheEqualsToPivotIdx++;
            }
        }

        // Move pivot to its final place
        ArrayHelper.swap(arr, hi, greatestFromTheEqualsToPivotIdx);

        // Return
        if( n < greatestFromTheLessThanThePivotIdx )
            return greatestFromTheEqualsToPivotIdx;
        if( n <= greatestFromTheEqualsToPivotIdx )
            return n;
        return greatestFromTheEqualsToPivotIdx;
    }


    private int __pivot( int [] arr, int lo, int hi ){
        if( hi - lo < 5 )
            return __sortFiveElementsArrayAndGetMedian(arr, lo, hi );
        for ( int i = lo; i <= hi; i += 5 ){
            int subTo = i + 4;
            if ( subTo > hi )
                subTo = hi;
            int median5 = __sortFiveElementsArrayAndGetMedian( arr, i, subTo );
            ArrayHelper.swap( arr, i, subTo );
            ArrayHelper.swap( arr, median5, lo + (i - lo)/5 );
        }
        int mid = (lo - hi) / 10 + lo + 1;

        return __select( arr, lo, lo + ( hi - lo )/5, mid );
    }

    private int __sortFiveElementsArrayAndGetMedian( int[] arr, int lo, int hi ) {
        int i,j;

        i = lo + 1;

        while ( i <= hi ) {
            j = i;
            while ( j > lo && arr[j-1] > arr[j] ){
                ArrayHelper.swap(arr, j-i, j);
                j--;
            }
            i++;
        }
        return ( lo + hi ) / 2;
    }
}
