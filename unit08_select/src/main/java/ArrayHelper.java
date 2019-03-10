public class ArrayHelper {

    ArrayHelper(){}

    public static void swap( int[] array, int idx1, int idx2 ) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public static int[] newArray( int length ) {
        return new int [length];
    }

    public static void copyElements( int[] src, int[] dest, int idxFrom, int idxTo ) {
        for(int i = idxFrom; i <= idxTo; i++){
            dest[i] = src[i];
        }
    }

    public static int[] extractSubarray( int[] src, int idxFrom, int idxTo ) {
        int [] subArr = newArray(idxTo-idxFrom+1 );
        System.arraycopy(src, idxFrom, subArr, 0, idxTo-idxFrom+1);
        return subArr;
    }

    public static void replaceSubarray( int[] arr, int[] sub, int idx ) {
        int size = sub.length;
        System.arraycopy(sub, 0, arr, idx, sub.length);
     }
}
