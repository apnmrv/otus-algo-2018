package Sorter;

public class ArrayHelper implements IArrayHelper {

    @Override
    public void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}
