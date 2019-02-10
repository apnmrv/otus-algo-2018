package MergeSorter;

public class Sorter implements ISorter {
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
            merge(firstIdx, middleIdx, lastIdx);
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
}