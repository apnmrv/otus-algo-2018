package InsertionSorter;

import Main.ISorter;

public class InsertionSorter implements ISorter {

    private static final String TITLE = "Insertion Sort";

    @Override
    public int[] sort(int[] numbers) {

        int size = numbers.length;
        int i,j,key;

        for(i = 1; i < size; i++) {
            key = numbers[i];

            for (j = i-1; 0 <= j && numbers[j] > key; j--) {
                numbers[j + 1] = numbers[j];
            }
            numbers[j+1] = key;
        }

        return numbers;
    }

    @Override
    public String title() {
        return TITLE;
    }
}
