package MergeSorter;

public class SimpleMergeSorter implements ISorter {
    private int[] _arrIn;
    private int [] _arrOut;

    @Override
    public int[] sort(int[] array) {
        _arrIn = array;
        mergesort(0, array.length-1);
        return _arrOut;
    }

    private void mergesort(int firstIdx, int lastIdx) {

        if( lastIdx > firstIdx ) {
            int middleIdx = ( lastIdx + firstIdx ) / 2;
            mergesort(firstIdx, middleIdx);
            mergesort(middleIdx+1, lastIdx);
//            merge(firstIdx, middleIdx, lastIdx);
            oneMoreMerge(firstIdx, middleIdx, lastIdx);
        }
    }

    private void merge(int firstIdx, int middleIdx, int lastIdx) {
        _arrOut = _arrIn.clone();
        int i = firstIdx;
        int j = middleIdx+1;

        for(int k = firstIdx; k <= lastIdx; k++) {
            if( i <= middleIdx && ( j > lastIdx || _arrIn[i] <= _arrIn[j])){

                _arrOut[k] = _arrIn[i];
                i++;
            } else {

                _arrOut[k] = _arrIn[j];
                j++;
            }
        }
        _arrIn = _arrOut.clone();
    }

    private void oneMoreMerge(int firstIdx, int middleIdx, int lastIdx){

        int n1 = middleIdx-firstIdx+1;
        int n2 = lastIdx-middleIdx;
        int [] left = new int[n1+1];
        int [] right = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            left[i] = _arrIn[i];
        }
        left[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            right[i] = _arrIn[i];
        }
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = firstIdx; k <= lastIdx; k++){
            if(left[i]<=right[j]) {
                _arrIn[k] = left[i];
                i++;
            } else {
                _arrIn[k] = right[j];
                j++;
            }
        }
        _arrOut = _arrIn.clone();
    }
}