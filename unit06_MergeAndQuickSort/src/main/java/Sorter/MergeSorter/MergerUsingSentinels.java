package Sorter.MergeSorter;

public class MergerUsingSentinels implements IMerger {

    MergerUsingSentinels(){}

    @Override
    public void merge(int[] arrOut, int[] arrIn, int firstIdx, int middleIdx, int lastIdx) {
        int n1 = middleIdx-firstIdx+1;
        int n2 = lastIdx-middleIdx;
        int [] left = new int[n1+1];
        int [] right = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            left[i] = arrOut[i];
        }
        left[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            right[i] = arrOut[i];
        }
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = firstIdx; k <= lastIdx; k++){
            if(left[i]<=right[j]) {
                arrOut[k] = left[i];
                i++;
            } else {
                arrOut[k] = right[j];
                j++;
            }
        }
    }
}
