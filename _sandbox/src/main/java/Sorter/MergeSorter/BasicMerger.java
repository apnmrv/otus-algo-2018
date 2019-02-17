package Sorter.MergeSorter;

public class BasicMerger implements IMerger {

    @Override
    public void merge(int [] arrOut, int [] arrIn, int firstIdx, int middleIdx, int lastIdx) {

        int i = firstIdx;
        int j = middleIdx+1;

        for(int k = firstIdx; k <= lastIdx; k++) {
            if( i <= middleIdx && ( j > lastIdx || arrIn[i] <= arrIn[j])){

                arrOut[k] = arrIn[i];
                i++;
            } else {
                arrOut[k] = arrIn[j];
                j++;
            }
        }
    }
}
